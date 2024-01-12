package com.example.gigsandcare.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.example.agrisight.ui.common.UiState
import com.example.gigsandcare.ui.screen.signin.component.SignInResult
import com.example.gigsandcare.ui.screen.signin.component.SignInState
import com.example.gigsandcare.ui.screen.signin.component.UserData
import com.example.gigsandcare.R
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.data.model.dummyBannerDetail
import com.example.gigsandcare.data.model.dummyPrograms
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.cancellation.CancellationException

class GigsAndCareRepository(
    private val context: Context,
    private val auth: FirebaseAuth,
    private val oneTapClient: SignInClient
) {

    fun getPrograms(): Flow<List<Program>> {
        val data = dummyPrograms
        return flowOf(data)
    }

    fun getProgramDetail(index: Int): Flow<Program> {
        val data = dummyPrograms[index]
        return flowOf(data)
    }

    fun getBannerDetail(index: Int): Flow<Program> {
        val data = dummyBannerDetail[index]
        return flowOf(data)
    }

    suspend fun signInGoogle(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            null
        }

        return result?.pendingIntent?.intentSender
    }

    suspend fun signInWithIntentGoogle(intent: Intent): SignInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val user = auth.signInWithCredential(googleCredentials).await().user
            SignInResult(
                data = user?.run {
                    UserData(
                        userId = uid,
                        email = displayName,
                        profilePictureUrl = photoUrl?.toString()
                    )
                },
                errorMessage = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            SignInResult(
                data = null,
                errorMessage = e.message
            )
        }
    }

    suspend fun signOut() {
        try {
            oneTapClient.signOut().await()
            auth.signOut()
        } catch (e:Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
        }
    }

    fun onSignInGoogleResult(result: SignInResult): SignInResult {
        return result
    }

    fun resetGoogleAccountState(): SignInState {
        return SignInState()
    }

    fun getSignedInUser(): UserData? = auth.currentUser?.run {
        UserData(
            userId = uid,
            email = email,
            profilePictureUrl = photoUrl?.toString()
        )
    }

    private fun buildSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.Builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(context.getString(R.string.web_client_id))
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }

    suspend fun signUpWithEmail(
        email: String, password: String
    ) = try {
        auth.createUserWithEmailAndPassword(email, password).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun signInWithEmail(
        email: String, password: String
    ) = try {
        auth.signInWithEmailAndPassword(email, password).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    suspend fun resetPassword(email: String) = try {
        auth.sendPasswordResetEmail(email).await()
        UiState.Success(true)
    } catch (e: Exception) {
        e.message?.let { UiState.Error(it) }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: GigsAndCareRepository? = null
        fun getInstance(
            context: Context,
            auth: FirebaseAuth,
            oneTapClient: SignInClient
        ): GigsAndCareRepository =
            instance ?: synchronized(this) {
                instance ?: GigsAndCareRepository(context, auth, oneTapClient)
            }.also { instance = it }
    }
}