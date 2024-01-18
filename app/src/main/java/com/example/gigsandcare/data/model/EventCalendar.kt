package com.example.gigsandcare.data.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class EventCalendar(
    @DocumentId val id: String = "",
    @ServerTimestamp val createdAt: Date = Date(),
    val eventCalendarId: String = "",
    val userId: String = "",
    val title: String = "",
    val date: String = "",
    val description: String = ""
)
