package com.andreesperanca.quegrupobom.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.andreesperanca.quegrupobom.util.generics.BaseFragment
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.adapters.CategoriaDestaquesAdapter
import com.andreesperanca.quegrupobom.adapters.ComunidadeDestaqueAdapter
import com.andreesperanca.quegrupobom.data.remote.MockData
import com.andreesperanca.quegrupobom.databinding.FragmentInicioBinding


class InicioFragment : BaseFragment<FragmentInicioBinding>(
    FragmentInicioBinding::inflate
) {

    private val data by lazy { MockData(requireContext()) }
    private val adapter by lazy { ComunidadeDestaqueAdapter(data.buscarComunidadesDestaques()) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureCarouselAdapter()
        configureAdapter()
    }

    private fun configureAdapter() {
        binding.rvCategory.adapter = CategoriaDestaquesAdapter(data.buscarCategoriasDestaques())
        binding.rvCategory.layoutManager =
            LinearLayoutManager(requireContext(), VERTICAL, false)

    }
    private fun configureCarouselAdapter() {
        binding.rvDestaqueComunidade.adapter = adapter
        binding.rvDestaqueComunidade.setAlpha(true)
        binding.rvDestaqueComunidade.setInfinite(true)
    }
    override fun configureToolbar() {
        binding.tbInicioToolbar.apply {
            inflateMenu(R.menu.toolbar_menu)
            title = getString(R.string.app_name)
            setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.procurarPorNome -> {
                        findNavController().navigate(R.id.action_homeFragment_to_buscarComunidadesPorNome)
                        true
                    }
                    R.id.buscarPorCategoria -> {
                        findNavController().navigate(R.id.action_homeFragment_to_categoriaFragment)
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
}