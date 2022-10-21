package com.andreesperanca.quegrupobom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.quegrupobom.adapters.ComunidadeAdapter.ComunidadeViewHolder
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.databinding.ComunidadeItemBinding

class ComunidadeAdapter(private val comunidades: List<Comunidade>) :
    RecyclerView.Adapter<ComunidadeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComunidadeViewHolder {
        val binding =
            ComunidadeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComunidadeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComunidadeViewHolder, position: Int) {
        holder.bind(comunidades[position])
    }

    override fun getItemCount(): Int = comunidades.size

    inner class ComunidadeViewHolder(private val binding: ComunidadeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comunidade: Comunidade) {
            binding.ivComunidade.setImageDrawable(comunidade.image)
        }
    }
}