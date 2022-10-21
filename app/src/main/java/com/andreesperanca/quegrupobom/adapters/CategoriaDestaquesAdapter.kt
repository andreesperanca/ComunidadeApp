package com.andreesperanca.quegrupobom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.andreesperanca.quegrupobom.adapters.CategoriaDestaquesAdapter.CategoriaDestaqueViewHolder
import com.andreesperanca.quegrupobom.models.Categoria
import com.andreesperanca.quegrupobom.databinding.CategoriaItemBinding

class CategoriaDestaquesAdapter() : RecyclerView.Adapter<CategoriaDestaqueViewHolder>() {

    private var categorias: List<Categoria> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaDestaqueViewHolder {
        val binding =
            CategoriaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriaDestaqueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriaDestaqueViewHolder, position: Int) {
        holder.bind(categorias[position])
    }

    fun atualizaDestaques(novaLista: List<Categoria>?) {
        if(!novaLista.isNullOrEmpty()) {
            categorias = novaLista
            notifyItemChanged(novaLista.size)
        }
    }


    override fun getItemCount(): Int = categorias.size

    inner class CategoriaDestaqueViewHolder(private val binding: CategoriaItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categoria: Categoria) {
            binding.txtTitle.text = categoria.titulo
            binding.rvCategory.adapter = ComunidadeAdapter(categoria.comunidades)
            binding.rvCategory.layoutManager =
                LinearLayoutManager(binding.root.context, HORIZONTAL, false)

        }
    }
}