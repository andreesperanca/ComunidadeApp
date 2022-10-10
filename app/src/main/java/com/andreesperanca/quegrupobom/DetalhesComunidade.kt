package com.andreesperanca.quegrupobom

import android.os.Bundle
import android.view.View
import com.andreesperanca.quegrupobom.databinding.FragmentDetalhesComunidadeBinding
import com.andreesperanca.quegrupobom.util.generics.BaseFragment


class DetalhesComunidade : BaseFragment<FragmentDetalhesComunidadeBinding>(
    FragmentDetalhesComunidadeBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun configureToolbar() {

    }
}