package com.andreesperanca.quegrupobom.ui.inicio

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.adapters.CategoriaDestaquesAdapter
import com.andreesperanca.quegrupobom.adapters.ComunidadeDestaqueAdapter
import com.andreesperanca.quegrupobom.data.Resource
import com.andreesperanca.quegrupobom.data.remote.MockData
import com.andreesperanca.quegrupobom.databinding.FragmentInicioBinding
import com.andreesperanca.quegrupobom.repositories.inicio.InicioRepositoryImpl
import com.andreesperanca.quegrupobom.util.generics.BaseFragment
import com.google.android.material.snackbar.Snackbar
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview


class InicioFragment: BaseFragment<FragmentInicioBinding>(R.layout.fragment_inicio){

    private lateinit var rvComunidadesDestaques: CarouselRecyclerview
    private lateinit var rvCategoriasDestaques: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val comunidadesAdapter by lazy {
        ComunidadeDestaqueAdapter()
    }
    private val categoriasAdapter by lazy {
        CategoriaDestaquesAdapter()
    }

    private val viewModel by viewModels<InicioViewModel> {
        InicioViewModelFactory(
            InicioRepositoryImpl(MockData(requireContext()))
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureCarouselAdapter()
        configureAdapter()
        viewModel.buscarDestaques()

    }
    private fun configureAdapter() {
        rvCategoriasDestaques.adapter = categoriasAdapter
        rvCategoriasDestaques.layoutManager =
            LinearLayoutManager(requireContext(), VERTICAL, false)

    }
    private fun configureCarouselAdapter() {
        rvComunidadesDestaques.adapter = comunidadesAdapter
        rvComunidadesDestaques.setAlpha(true)
    }
    override fun setupObservers() {
        viewModel.comunidadesDestaques.observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Loading -> { binding.pgInicio.visibility = View.VISIBLE }
                is Resource.Success -> {
                    comunidadesAdapter.atualizaDestaques(it.data)
                    progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error ->  {
                    Snackbar.make(binding.root, it.message.toString(), Snackbar.LENGTH_LONG).show()
                    progressBar.visibility = View.INVISIBLE}
            }
        }
        viewModel.categoriasDestaques.observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    categoriasAdapter.atualizaDestaques(it.data)
                    progressBar.visibility = View.INVISIBLE
                }
                is Resource.Error ->  {}
            }
        }
    }
    override fun setupToolbar() {
        binding.tbInicioToolbar.apply {
            inflateMenu(R.menu.toolbar_menu)
            title = getString(R.string.app_name)
            setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.procurarPorNome -> {
                        findNavController().navigate(R.id.action_inicioFragment_to_buscarComunidadesPorNome)
                        true
                    }
                    R.id.buscarPorCategoria -> {
                        findNavController().navigate(R.id.action_inicioFragment_to_categoriaFragment)
                        true
                    }
                    R.id.buscarPorFavoritos -> {
                        true
                    }

                    else -> {false}
                }
            }
        }
    }
    override fun setupViewModel() {
        rvComunidadesDestaques = binding.rvComunidadesDestaques
        rvCategoriasDestaques = binding.rvCategoriasDestaques
        progressBar = binding.pgInicio
    }
}