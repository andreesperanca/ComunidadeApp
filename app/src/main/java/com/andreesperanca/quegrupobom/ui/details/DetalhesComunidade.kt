package com.andreesperanca.quegrupobom.ui.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.andreesperanca.quegrupobom.adapters.ComunidadesRecomendadasAdapter
import com.andreesperanca.quegrupobom.util.generics.BaseFragment
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.databinding.FragmentDetalhesComunidadeBinding
import com.google.android.material.snackbar.Snackbar


class DetalhesComunidade : BaseFragment<FragmentDetalhesComunidadeBinding>(
    R.layout.fragment_detalhes_comunidade
) {
    private val args: DetalhesComunidadeArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populandoFragment()
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        binding.rvRecomendados.adapter = ComunidadesRecomendadasAdapter(requireContext())
        binding.rvRecomendados.layoutManager =
            LinearLayoutManager(requireContext(), HORIZONTAL, false)
    }

    private fun populandoFragment() {
        with(binding) {
            val comunidade = args.comunidade
            ivComunidadeBanner.setImageDrawable(args.comunidade.image)
            tvNomeComunidade.text = comunidade.nome
            tvDescricao.text = comunidade.descricao
            tvRegras.text = comunidade.regras
            redesSociais.apply {
                acaoDiscordClique {
                    Snackbar.make(binding.root, "Discord", Snackbar.LENGTH_LONG).show()
                }
                acaoTelegramClique {
                    Snackbar.make(binding.root, "Telegram", Snackbar.LENGTH_LONG).show()
                }
                acaoYoutubeClique {
                    Snackbar.make(binding.root, "Youtube", Snackbar.LENGTH_LONG).show()
                }
            }
            comunidadeDetalhes.apply {
                colocarAdministrador(comunidade.criadorComunidade)
                colocarDataCriacao(comunidade.dataCriacao)
                colocarVisualizacoes(comunidade.visualizacoes)
            }
        }
    }

    override fun setupToolbar() {
        binding.comunidadeToolbar.apply {
            setNavigationIcon(R.drawable.ic_seta_esquerda_branca)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }

    override fun setupViewModel() {
    }

    override fun setupObservers() {
    }
}