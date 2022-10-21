package com.andreesperanca.quegrupobom.data.remote

import android.content.Context
import androidx.core.content.ContextCompat
import com.andreesperanca.quegrupobom.models.Categoria
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.R

class MockData(private val context: Context) {


    val buscarTresDestaques: List<Comunidade> = listOf(
        Comunidade("Teste",
            ContextCompat.getDrawable(context, R.drawable.ad_astra)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
            ),
        Comunidade("Teste",
            ContextCompat.getDrawable(context, R.drawable.beach_bum)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        ),
        Comunidade("Teste",
            ContextCompat.getDrawable(context, R.drawable.glass)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        ))

    val fragmentBuscarComunidades : List<Comunidade> = listOf(
        Comunidade("Teste",
            ContextCompat.getDrawable(context, R.drawable.ad_astra)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        ),
        Comunidade("Teste2",
            ContextCompat.getDrawable(context, R.drawable.ad_astra)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        ),
        Comunidade("Teste3",
            ContextCompat.getDrawable(context, R.drawable.ad_astra)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        )
    )

    val buscarComunidadesGenericas: List<Comunidade> = listOf(
        Comunidade("Teste",
            ContextCompat.getDrawable(context, R.drawable.ad_astra)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        ), Comunidade("Teste",
            ContextCompat.getDrawable(context, R.drawable.ad_astra)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        ), Comunidade("Teste",
            ContextCompat.getDrawable(context, R.drawable.ad_astra)!!,
            "20",
            "21/08/2000",
            "Andre",
            "Descrição boa",
            "Regras Boas"
        ),

    )

    fun buscarCategoriasDestaques() : List<Categoria> = listOf(
        Categoria("Memes", buscarComunidadesGenericas),
        Categoria("Estudos", buscarComunidadesGenericas),
        Categoria("Pipoca e ação", buscarComunidadesGenericas),
        Categoria("Culinária", buscarComunidadesGenericas)
    )

    fun buscarComunidadePorCategoria() : List<Categoria> = listOf(
        Categoria("Memes", buscarTresDestaques),
        Categoria("Casa", emptyList()),
    )
}