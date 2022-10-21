package com.andreesperanca.quegrupobom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.quegrupobom.adapters.BuscarComunidadeAdapter.*
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.databinding.BuscarComunidadeItemBinding
import com.andreesperanca.quegrupobom.ui.buscar.BuscarComunidadeFragmentDirections


class BuscarComunidadeAdapter() : RecyclerView.Adapter<BuscarComunidadeViewHolder>() {

    private var comunidadeLista: List<Comunidade> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuscarComunidadeViewHolder {

        val binding =
            BuscarComunidadeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuscarComunidadeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuscarComunidadeViewHolder, position: Int) {
        holder.bind(comunidadeLista[position])
    }

    override fun getItemCount(): Int = comunidadeLista.size

    fun atualizar(adapterList: List<Comunidade>) {
        adapterList.let {
            if (adapterList.isNotEmpty()) {
                comunidadeLista = adapterList
                notifyDataSetChanged()
            } else {
                comunidadeLista = emptyList()
                notifyDataSetChanged()
            }
        }
    }

    inner class BuscarComunidadeViewHolder(private val binding: BuscarComunidadeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comunidade: Comunidade) {
            binding.ivComunidadeFoto.setImageDrawable(comunidade.image)
            binding.tvNomeComunidade.text = comunidade.nome

            binding.root.setOnClickListener {
                val action =
                    BuscarComunidadeFragmentDirections.actionBuscarComunidadesPorNomeToDetalhesComunidade(
                        comunidade
                    )
                it.findNavController().navigate(action)
            }
        }
    }
}