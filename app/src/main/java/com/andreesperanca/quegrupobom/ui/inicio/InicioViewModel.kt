package com.andreesperanca.quegrupobom.ui.inicio

import androidx.lifecycle.*
import com.andreesperanca.quegrupobom.data.Resource
import com.andreesperanca.quegrupobom.models.Categoria
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.repositories.inicio.InicioRepository
import kotlinx.coroutines.launch

class InicioViewModel(private val repository: InicioRepository) : ViewModel() {

    private val _categoriasDestaques = MutableLiveData<Resource<List<Categoria>>>()
    val categoriasDestaques: LiveData<Resource<List<Categoria>>> = _categoriasDestaques

    private val _comunidadesDestaques = MutableLiveData<Resource<List<Comunidade>>>()
    val comunidadesDestaques: LiveData<Resource<List<Comunidade>>> = _comunidadesDestaques

    private val _progressBarVisivel = MutableLiveData<Boolean>()
    val progressBarVisivel: LiveData<Boolean> = _progressBarVisivel

    fun buscarDestaques() {
        _comunidadesDestaques.value = Resource.Loading()
        viewModelScope.launch {
            _comunidadesDestaques.value = repository.buscarComunidadesDestaques()
            _categoriasDestaques.value = repository.buscarCategoriasDestaques()
        }
    }
}

@Suppress("UNCHECKED_CAST")
class InicioViewModelFactory(
    private val repository: InicioRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (InicioViewModel(repository) as T)
}


