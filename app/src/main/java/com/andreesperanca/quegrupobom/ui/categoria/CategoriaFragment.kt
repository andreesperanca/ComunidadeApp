package com.andreesperanca.quegrupobom.ui.categoria

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andreesperanca.quegrupobom.adapters.BuscarComunidadeAdapter
import com.andreesperanca.quegrupobom.data.remote.MockData
import com.andreesperanca.quegrupobom.models.Categoria
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.util.generics.BaseFragment
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.databinding.FragmentCategoriaBinding


class CategoriaFragment : BaseFragment<FragmentCategoriaBinding>(
    R.layout.fragment_categoria), AdapterView.OnItemSelectedListener
{

    private lateinit var  adapter: BuscarComunidadeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        configureAdapter()
        configureSpinner()
    }

    private fun configureSpinner() {
        val spinner = binding.mySpinner
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.categories_array,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
    }
    private fun configureAdapter() {
        adapter = BuscarComunidadeAdapter()
        binding.rvCategoria.adapter = adapter
        binding.rvCategoria.layoutManager = LinearLayoutManager(requireContext())
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val termosDeBusca = parent?.selectedItem
        val categorias = MockData(requireContext()).buscarComunidadePorCategoria()
        val adapterList = filtroTeste(categorias, termosDeBusca.toString())
        adapter.atualizar(adapterList)
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
    private fun filtroTeste (listCategorias: List<Categoria>, termosDeBusca: String) : List<Comunidade> {
        val categoria = listCategorias.filter { categoria -> categoria.titulo == termosDeBusca }
        return categoria.first().comunidades
    }

    override fun setupToolbar() {
        binding.tbInicioToolbar.apply {
            title = getString(R.string.buscarComunidadePorCategoria)
            setNavigationIcon(R.drawable.ic_seta_esquerda_branca)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }
    override fun setupViewModel() {

    }
    override fun setupObservers() {

    }
}

