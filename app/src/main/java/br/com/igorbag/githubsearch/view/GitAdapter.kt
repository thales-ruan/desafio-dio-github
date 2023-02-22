package br.com.igorbag.githubsearch.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.databinding.ItemAdapterBinding
import br.com.igorbag.githubsearch.model.GitModel

class GitAdapter : RecyclerView.Adapter<GitAdapter.ViewHolder>() {


    private var listrepository = emptyList<GitModel>()

    class ViewHolder(val binding: ItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repository: GitModel) {
            binding.tvRepository.text = repository.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAdapterBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listrepository[position])
    }

    override fun getItemCount(): Int {
        return listrepository.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setRepository(repositories: List<GitModel>) {
        listrepository = repositories
        notifyDataSetChanged()
    }

}