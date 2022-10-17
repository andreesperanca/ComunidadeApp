package com.andreesperanca.quegrupobom.util.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.databinding.ComunidadeRedesItemBinding

class ComunidadeRedesCustom @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding =
        ComunidadeRedesItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        configurar(context, attrs)
    }

    private fun configurar(context: Context, attrs: AttributeSet) {
        val typeArray =
            context.obtainStyledAttributes(attrs, R.styleable.ComunidadeRedesCustom, 0, 0)
        typeArray.recycle()
    }

    fun acaoYoutubeClique (action : () -> Unit) {
        binding.ivYoutube.setOnClickListener { action() }
    }

    fun acaoTelegramClique (action : () -> Unit) {
        binding.ivTelegram.setOnClickListener { action() }
    }

    fun acaoDiscordClique (action : () -> Unit) {
        binding.ivDiscord.setOnClickListener { action() }
    }
}