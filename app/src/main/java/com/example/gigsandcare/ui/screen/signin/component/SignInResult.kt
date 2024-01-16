package com.example.gigsandcare.ui.screen.signin.component

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String = "",
    val name: String? = "",
    val email: String? = "",
    val profilePictureUrl: String? = ""
)
