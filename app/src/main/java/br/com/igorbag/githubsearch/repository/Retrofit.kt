package com.example.desafiodiogithub.repository

import br.com.igorbag.githubsearch.constantes.BASE_URL
import br.com.igorbag.githubsearch.service.GitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: GitService by lazy {
        retrofit.create(GitService::class.java)
    }


}