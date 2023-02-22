package br.com.igorbag.githubsearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiodiogithub.repository.GitRepository

class ViewModelFactory  (private val gitRepository: GitRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(gitRepository) as T
    }

}