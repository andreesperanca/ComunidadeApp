package com.andreesperanca.quegrupobom.repositories.inicio

import com.andreesperanca.quegrupobom.data.Resource
import com.andreesperanca.quegrupobom.data.apiCall
import com.andreesperanca.quegrupobom.data.remote.MockData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InicioRepositoryImpl(
    private val remoteDataSource: MockData,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : InicioRepository {

    override suspend fun buscarComunidadesDestaques() = apiCall {
        withContext(ioDispatcher) {
            Resource.Success(data = remoteDataSource.buscarTresDestaques)
        }
    }

    override suspend fun buscarCategoriasDestaques() = apiCall {
        withContext(ioDispatcher) {
            Resource.Success(data = remoteDataSource.buscarCategoriasDestaques())
        }
    }
}