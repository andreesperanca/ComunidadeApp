package com.andreesperanca.quegrupobom.ui.buscar

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.adapters.BuscarComunidadeAdapter
import com.andreesperanca.quegrupobom.data.remote.MockData
import com.andreesperanca.quegrupobom.databinding.FragmentBuscarPorNomeBinding
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.util.generics.BaseFragment
import com.andreesperanca.quegrupobom.util.showKeyBoard

class BuscarComunidadeFragment :
    BaseFragment<FragmentBuscarPorNomeBinding>(
        R.layout.fragment_buscar_por_nome
    ) {

    private val adapter by lazy { BuscarComunidadeAdapter() }
    private val data by lazy { MockData(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureAdapter()
        configureSwiper()

        binding.buscarComunidadesPorNome.doOnTextChanged { text, _, _, _ ->
            val list = buscarComunidadePorNome(
                MockData(requireContext()).fragmentBuscarComunidades,
                text.toString()
            )
            adapter.atualizar(list)
        }
        this.showKeyBoard(binding.buscarComunidadesPorNome)

    }

    override fun onResume() {
        super.onResume()
        this.showKeyBoard(binding.buscarComunidadesPorNome)
    }

    private fun configureSwiper() {
        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val action =
                    BuscarComunidadeFragmentDirections.actionBuscarComunidadesPorNomeToDetalhesComunidade(
                        data.buscarComunidadesGenericas[viewHolder.adapterPosition]
                    )
                findNavController().navigate(action)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.rvBuscarComunidade)
    }

    private fun configureAdapter() {
        binding.rvBuscarComunidade.adapter = adapter
        val divisor = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.rvBuscarComunidade.layoutManager =
            LinearLayoutManager(requireContext(), VERTICAL, false)
        binding.rvBuscarComunidade.addItemDecoration(divisor)
    }

    private fun buscarComunidadePorNome(comunidades: List<Comunidade>, termosDeBusca: String): List<Comunidade> {
        val returnList = mutableListOf<Comunidade>()
        comunidades.forEach { comunidade ->
            val chars = termosDeBusca.toList()
            if (comunidade.nome.toList().containsAll(chars)) {
                returnList.add(comunidade)
            }
        }
        return returnList
    }

    override fun setupToolbar() {
        binding.tbInicioToolbar.apply {
            setNavigationIcon(R.drawable.ic_seta_esquerda_branca)
            title = getString(R.string.buscarComunidades)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun setupViewModel() {
    }

    override fun setupObservers() {
    }

}