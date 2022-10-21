package com.andreesperanca.quegrupobom.models

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Comunidade(
    val nome: String,
    val image: @RawValue Drawable,
    val visualizacoes: String,
    val dataCriacao: String,
    val criadorComunidade: String,
    val descricao: String,
    val regras: String
) : Parcelable
