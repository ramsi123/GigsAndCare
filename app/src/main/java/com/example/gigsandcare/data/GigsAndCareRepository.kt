package com.example.gigsandcare.data

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.util.Log
import com.example.agrisight.ui.common.UiState
import com.example.gigsandcare.ui.screen.signin.component.SignInResult
import com.example.gigsandcare.ui.screen.signin.component.SignInState
import com.example.gigsandcare.ui.screen.signin.component.UserData
import com.example.gigsandcare.R
import com.example.gigsandcare.data.model.EventCalendar
import com.example.gigsandcare.data.model.News
import com.example.gigsandcare.data.model.UserDonation
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.data.model.UserHistory
import com.example.gigsandcare.data.model.dummyBannerDetail
import com.example.gigsandcare.data.model.dummyCharityPrograms
import com.example.gigsandcare.data.model.dummyConcerts
import com.example.gigsandcare.data.model.dummyLatestNews
import com.example.gigsandcare.data.model.dummyPrograms
import com.example.gigsandcare.data.model.dummyRecommendedTopic
import com.example.gigsandcare.data.model.dummyUserHistory
import com.example.gigsandcare.util.Constants.DONATE_COLLECTION
import com.example.gigsandcare.util.Constants.EVENT_CALENDAR_COLLECTION
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.tasks.await
import java.time.LocalDate
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

@ViewModelScoped
class GigsAndCareRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val oneTapClient: SignInClient
) {

    fun getPrograms(): Flow<List<Program>> {
        val data = dummyPrograms
        return flowOf(data)
    }

    fun getCharityPrograms(): Flow<List<Program>> {
        val data = dummyCharityPrograms
        return flowOf(data)
    }

    fun getConcerts(): Flow<List<Program>> {
        val data = dummyConcerts
        return flowOf(data)
    }

    fun getLatestNews(): Flow<List<News>> {
        val data = dummyLatestNews
        return flowOf(data)
    }

    fun getRecommendedTopic(): Flow<List<News>> {
        val data = dummyRecommendedTopic
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

    fun getCharityProgramDetail(index: Int): Flow<Program> {
        val data = dummyCharityPrograms[index]
        return flowOf(data)
    }

    fun getConcertDetail(index: Int): Flow<Program> {
        val data = dummyConcerts[index]
        return flowOf(data)
    }

    fun getLatestNewsDetail(index: Int): Flow<News> {
        val data = dummyLatestNews[index]
        return flowOf(data)
    }

    fun getRecommendedTopicDetail(index: Int): Flow<News> {
        val data = dummyRecommendedTopic[index]
        return flowOf(data)
    }

    fun getUserHistory(): Flow<List<UserHistory>> {
        val data = dummyUserHistory
        return flowOf(data)
    }

    suspend fun addDonation(userDonation: UserDonation) {
        val updatedData = userDonation.copy(userId = auth.currentUser?.uid ?: "")
        firestore.collection(DONATE_COLLECTION).add(updatedData).await()
    }

    suspend fun addEventCalendar(eventCalendar: EventCalendar) {
        val updatedData = eventCalendar.copy(
            userId = auth.currentUser?.uid ?: "",
            eventCalendarId = "eventCalendar-${LocalDate.now()}"
        )
        firestore.collection(EVENT_CALENDAR_COLLECTION).add(updatedData).await()
    }

    suspend fun getUserHistoryData(): Flow<List<UserDonation>> {
        return try {
            val querySnapshot = firestore.collection(DONATE_COLLECTION)
                .whereEqualTo("userId", auth.currentUser?.uid)
                .get()
                .await()
            val userData = querySnapshot.documents.mapNotNull {
                it.toObject(UserDonation::class.java)
            }
            flowOf(userData)
        } catch (e: Exception) {
            Log.e("Error", "Error fetching donation history", e)
            flowOf(emptyList())
        }
    }

    suspend fun getEventCalendar(): Flow<List<EventCalendar>> {
        return try {
            val querySnapshot = firestore.collection(EVENT_CALENDAR_COLLECTION)
                .whereEqualTo("userId", auth.currentUser?.uid)
                .get()
                .await()
            val eventCalendar = querySnapshot.documents.mapNotNull {
                it.toObject(EventCalendar::class.java)
            }
            flowOf(eventCalendar)
        } catch (e: Exception) {
            Log.e("Error", "Error fetching donation history", e)
            flowOf(emptyList())
        }
    }

    suspend fun getEventCalendarItem(eventCalendarId: String): Flow<List<EventCalendar>> {
        return try {
            val querySnapshot = firestore.collection(EVENT_CALENDAR_COLLECTION)
                .whereEqualTo("userId", auth.currentUser?.uid)
                .whereEqualTo("eventCalendarId", eventCalendarId)
                .get()
                .await()
            val eventCalendar = querySnapshot.documents.mapNotNull {
                it.toObject(EventCalendar::class.java)
            }
            flowOf(eventCalendar)
        } catch (e: Exception) {
            Log.e("Error", "Error fetching donation history", e)
            flowOf(emptyList())
        }
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
            name = displayName,
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
}