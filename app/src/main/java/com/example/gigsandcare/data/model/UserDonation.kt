package com.example.gigsandcare.data.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class UserDonation(
    @DocumentId val id: String = "",
    @ServerTimestamp val createdAt: Date = Date(),
    val userId: String = "",
    val peoplesHelped: Int = 0,
    val totalSpend: Int = 0,
    val totalCharityProgram: Int = 0
)