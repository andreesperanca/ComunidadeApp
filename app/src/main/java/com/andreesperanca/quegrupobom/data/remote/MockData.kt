package com.andreesperanca.quegrupobom.data.remote

import android.content.Context
import androidx.core.content.ContextCompat
import com.andreesperanca.quegrupobom.R
import com.andreesperanca.quegrupobom.models.Categoria
import com.andreesperanca.quegrupobom.models.Comunidade

class MockData(private val context: Context) {

    val buscarComunidades: List<Comunidade> = listOf(
        Comunidade("Memes", ContextCompat.getDrawable(context, R.drawable.glass)!!),
        Comunidade("Cachorros", ContextCompat.getDrawable(context, R.drawable.glass)!!),
        Comunidade("abc", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("abcd", ContextCompat.getDrawable(context, R.drawable.glass)!!),
        Comunidade("abcde", ContextCompat.getDrawable(context, R.drawable.glass)!!),
        Comunidade("abcdef", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("abcdefg", ContextCompat.getDrawable(context, R.drawable.glass)!!),
        Comunidade("abcdefgh", ContextCompat.getDrawable(context, R.drawable.glass)!!),
        Comunidade("abcdefghi", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("abcdefghij", ContextCompat.getDrawable(context, R.drawable.glass)!!),
        Comunidade("abcdefghijk", ContextCompat.getDrawable(context, R.drawable.glass)!!),


    )

    fun buscarComunidadesDestaques(): List<Comunidade> = listOf<Comunidade>(
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.ad_astra)!!),
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.beach_bum)!!),
        Comunidade("Teste", ContextCompat.getDrawable(context, R.drawable.glass)!!)
    )

    fun buscarCategoriasDestaques() : List<Categoria> = listOf(
        Categoria("Memes", buscarComunidadesDestaques()),
        Categoria("Estudos", buscarComunidadesDestaques()),
        Categoria("Pipoca e ação", buscarComunidadesDestaques()),
        Categoria("Culinária", buscarComunidadesDestaques())
    )

    fun buscarComunidadePorCategoria() : List<Categoria> = listOf(
        Categoria("Memes", buscarComunidadesDestaques()),
        Categoria("Casa", emptyList()),
    )
}