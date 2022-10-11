package com.andreesperanca.quegrupobom

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.andreesperanca.quegrupobom.databinding.FragmentDetalhesComunidadeBinding
import com.andreesperanca.quegrupobom.util.generics.BaseFragment


class DetalhesComunidade : BaseFragment<FragmentDetalhesComunidadeBinding>(
    FragmentDetalhesComunidadeBinding::inflate
) {

    private val args: DetalhesComunidadeArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.ivComunidadeBanner.setImageDrawable(args.comunidade.image)
        binding.tvNomeComunidade.text = "Comunidade dos nerds"
        binding.tvRedesSociaisTitulo.text = "Redes sociais"
        binding.tvDescricaoTitulo.text = "Descrição grupo"
        binding.tvDescricaoComunidade.text = "aqui tem uma descricao bem bonita"
        binding.tvRegrasComunidadeTitle.text = "Regras comunidade"
        binding.tvRegrasComunidade.text = "Aqui tem as regras bem bonitas"
    }

    override fun configureToolbar() {
        binding.comunidadeToolbar.apply {
            setNavigationIcon(R.drawable.ic_seta_esquerda_branca)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }
}