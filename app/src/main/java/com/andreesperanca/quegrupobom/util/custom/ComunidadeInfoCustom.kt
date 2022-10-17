package com.andreesperanca.quegrupobom.util.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.databinding.ComunidadeInfoItemBinding


class ComunidadeInfoCustom @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : LinearLayout (context, attrs, defStyleAttr) {

    private val binding = ComunidadeInfoItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        configurar(context, attrs)
    }

    private fun configurar(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ComunidadeInfoCustom, 0, 0)
        typedArray.recycle()
    }

    fun colocarVisualizacoes(visualizacoes: String) {
        binding.tvVisualizacoes.text = visualizacoes
    }

    fun colocarDataCriacao(dataCriacao: String) {
        binding.tvDataCriacao.text = dataCriacao
    }

    fun colocarAdministrador(administrador: String) {
        binding.tvNomeAdministrador.text = administrador
    }
}