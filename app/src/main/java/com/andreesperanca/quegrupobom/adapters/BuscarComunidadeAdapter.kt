package com.andreesperanca.quegrupobom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.adapters.BuscarComunidadeAdapter.BuscarComunidadeViewHolder
import com.andreesperanca.quegrupobom.databinding.BuscarComunidadeItemBinding
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.ui.fragments.BuscarComunidadeFragmentDirections

class BuscarComunidadeAdapter() : RecyclerView.Adapter<BuscarComunidadeViewHolder>() {

    private var comunidadeList: List<Comunidade> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuscarComunidadeViewHolder {

        val binding =
            BuscarComunidadeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuscarComunidadeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuscarComunidadeViewHolder, position: Int) {
        holder.bind(comunidadeList[position])
    }

    override fun getItemCount(): Int = comunidadeList.size

    fun atualizar(adapterList: List<Comunidade>) {
        adapterList.let {
            if (adapterList.isNotEmpty()) {
                comunidadeList = adapterList
                notifyDataSetChanged()
            } else {
                comunidadeList = emptyList()
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