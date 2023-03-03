package br.com.igorbag.githubsearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.igorbag.githubsearch.model.GitModel


import com.example.desafiodiogithub.repository.GitRepository
import kotlinx.coroutines.launch


class MainViewModel(val gitRepository: GitRepository) : ViewModel() {

    var listGit = MutableLiveData<List<GitModel>>()

    fun buscaGit(nome: String) {
        viewModelScope.launch {
            val response = gitRepository.getGit(nome)
            if (response.isSuccessful) {
                listGit.value = response.body()
            }
        }
    }

}