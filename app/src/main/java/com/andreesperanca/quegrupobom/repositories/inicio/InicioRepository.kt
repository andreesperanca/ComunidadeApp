package com.andreesperanca.quegrupobom.repositories.inicio

import com.andreesperanca.quegrupobom.data.Resource
import com.andreesperanca.quegrupobom.models.Categoria
import com.andreesperanca.quegrupobom.models.Comunidade

interface InicioRepository {
    suspend fun buscarComunidadesDestaques(): Resource<List<Comunidade>>
    suspend fun buscarCategoriasDestaques(): Resource<List<Categoria>>
}