package com.example.gigsandcare.data.model

import com.example.gigsandcare.R

data class Program(
    val id: Int = -1,
    val image: Int = R.drawable.charity_for_humanity,
    val title: String = "",
    val date: String = "",
    val location: String = "",
    val availability: String = "",
    val description: String = ""
)

val dummyPrograms = listOf(
    Program(id = 0, image = R.drawable.charity_for_humanity, title = "Anasthesia Concert For Charity", date = "12 January 2024", location = "Jl. Burung Puyuh, Kabupaten Mergoasin, Jakarta", availability = "Available", description = "Pijarity x Prime Community is an event held to provide charity to communities affected by natural disasters. With you buying this ticket, you will help the affected communities."),
    Program(id = 1, image = R.drawable.pijarity_beast, title = "Pijarity x Mr. Beast Foundation", date = "23 December 2024", location = "Jl. Bungurasih, Sumenep, Jawa Timur", availability = "Sold Out", description = "Pijarity x Prime Community is an event held to provide charity to communities affected by natural disasters. With you buying this ticket, you will help the affected communities."),
    Program(id = 2, image = R.drawable.pijarity_beast2, title = "Open Donation For Rohingya", date = "12 January 2024", location = "Jl. Burung Puyuh, Kabupaten Mergoasin, Jakarta", availability = "Available", description = "Pijarity x Prime Community is an event held to provide charity to communities affected by natural disasters. With you buying this ticket, you will help the affected communities."),
    Program(id = 3, image = R.drawable.charity_for_humanity, title = "Anasthesia Concert For Charity", date = "12 January 2024", location = "Jl. Burung Puyuh, Kabupaten Mergoasin, Jakarta", availability = "Sold Out", description = "Pijarity x Prime Community is an event held to provide charity to communities affected by natural disasters. With you buying this ticket, you will help the affected communities."),
    Program(id = 4, image = R.drawable.pijarity_beast, title = "Pijarity x Mr. Beast Foundation", date = "23 December 2024", location = "Jl. Bungurasih, Sumenep, Jawa Timur", availability = "Available", description = "Pijarity x Prime Community is an event held to provide charity to communities affected by natural disasters. With you buying this ticket, you will help the affected communities."),
    Program(id = 5, image = R.drawable.pijarity_beast2, title = "Open Donation For Rohingya", date = "12 January 2024", location = "Jl. Burung Puyuh, Kabupaten Mergoasin, Jakarta", availability = "Sold Out", description = "Pijarity x Prime Community is an event held to provide charity to communities affected by natural disasters. With you buying this ticket, you will help the affected communities.")
)