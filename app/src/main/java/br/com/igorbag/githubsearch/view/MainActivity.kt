package br.com.igorbag.githubsearch.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.igorbag.githubsearch.databinding.ActivityMainBinding
import br.com.igorbag.githubsearch.viewmodel.MainViewModel
import br.com.igorbag.githubsearch.viewmodel.ViewModelFactory
import com.example.desafiodiogithub.repository.GitRepository

class MainActivity : AppCompatActivity() {

    private val adapter = GitAdapter()
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels {
        ViewModelFactory(GitRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initRecycler()
        getRepository()
        observes()
    }

    private fun initRecycler() {
        val recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    private fun observes() {
        viewModel.listGit.observe(this) { response ->
                adapter.setRepository(response)
        }
    }

    private fun getRepository() {
        binding.btnConfirmar.setOnClickListener {
            viewModel.buscaGit(binding.etNomeUsuario.text.toString())
        }
    }


}