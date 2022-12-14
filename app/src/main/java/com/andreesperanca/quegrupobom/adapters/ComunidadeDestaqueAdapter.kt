package com.andreesperanca.quegrupobom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.quegrupobom.adapters.ComunidadeDestaqueAdapter.ComunidadeDestaqueViewHolder
import com.andreesperanca.quegrupobom.databinding.ComunidadeDestaqueItemBinding
import com.andreesperanca.quegrupobom.models.Comunidade

class ComunidadeDestaqueAdapter() : RecyclerView.Adapter<ComunidadeDestaqueViewHolder>() {

    private var comunidades: List<Comunidade> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComunidadeDestaqueViewHolder {
        val binding =
            ComunidadeDestaqueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComunidadeDestaqueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComunidadeDestaqueViewHolder, position: Int) {
        holder.bind(comunidades[position])
    }

    fun atualizaDestaques(novaLista: List<Comunidade>?) {
        if(!novaLista.isNullOrEmpty()) {
            comunidades = novaLista
            notifyItemChanged(novaLista.size)
        }
    }

    override fun getItemCount(): Int = comunidades.size

    inner class ComunidadeDestaqueViewHolder(private val binding: ComunidadeDestaqueItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comunidade: Comunidade) {
            binding.ivComunidade.setImageDrawable(comunidade.image)
        }
    }
}