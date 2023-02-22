package br.com.igorbag.githubsearch.service

import br.com.igorbag.githubsearch.model.GitModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("users/{user}/repos")
  suspend  fun getAllRepositoriesByUser(@Path("user") user: String): Response<List<GitModel>>

}