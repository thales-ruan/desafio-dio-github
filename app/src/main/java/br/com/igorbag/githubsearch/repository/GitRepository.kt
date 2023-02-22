package com.example.desafiodiogithub.repository

class GitRepository {

    suspend fun getGit(user: String) =
        Retrofit.api.getAllRepositoriesByUser(user)

}