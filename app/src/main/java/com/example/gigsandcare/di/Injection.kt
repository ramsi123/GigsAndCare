package com.example.gigsandcare.di

import android.content.Context
import com.example.gigsandcare.data.GigsAndCareRepository
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object Injection {
    fun provideGigsAndCareRepository(context: Context): GigsAndCareRepository {
        val auth = Firebase.auth
        val firestore = Firebase.firestore
        val oneTapClient = Identity.getSignInClient(context)
        return GigsAndCareRepository.getInstance(context, auth, firestore, oneTapClient)
    }
}