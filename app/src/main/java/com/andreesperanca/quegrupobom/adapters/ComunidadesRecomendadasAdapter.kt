package com.andreesperanca.quegrupobom.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.quegrupobom.adapters.ComunidadesRecomendadasAdapter.*
import com.andreesperanca.quegrupobom.data.remote.MockData
import com.andreesperanca.quegrupobom.databinding.ComunidadeItemBinding
import com.andreesperanca.quegrupobom.models.Comunidade

class ComunidadesRecomendadasAdapter(context: Context) : RecyclerView.Adapter<ComunidadesRecomendadasViewHolder>() {

    private val comunidadesRecomendadas: List<Comunidade> = MockData(context).buscarComunidadesGenericas

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComunidadesRecomendadasViewHolder {
        val binding =
            ComunidadeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComunidadesRecomendadasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComunidadesRecomendadasViewHolder, position: Int) {
        holder.bind(comunidadesRecomendadas[position])
    }

    override fun getItemCount(): Int = comunidadesRecomendadas.size

    inner class ComunidadesRecomendadasViewHolder(private val binding: ComunidadeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comunidade: Comunidade) {

            binding.ivComunidade.setImageDrawable(comunidade.image)

        }
    }
}
