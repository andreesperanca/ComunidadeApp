package com.andreesperanca.quegrupobom.ui.inicio

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.andreesperanca.quegrupobom.MainCoroutineRule
import com.andreesperanca.quegrupobom.data.Resource
import com.andreesperanca.quegrupobom.getOrAwaitValue
import com.andreesperanca.quegrupobom.models.Categoria
import com.andreesperanca.quegrupobom.models.Comunidade
import com.andreesperanca.quegrupobom.repositories.inicio.InicioRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config


@Config(sdk = [Build.VERSION_CODES.P])
class InicioViewModelTest {

    /** Executes each task synchronously using Architecture Components */
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    /** Set the main coroutines dispatcher for unit testing. */
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()


    private lateinit var viewModel: InicioViewModel
    private lateinit var repository: InicioRepository
    private lateinit var repositoryError: InicioRepository

    @Before
    fun configurarViewModel() {
        repository = MockInicioRepository(testeSucesso = true)
        repositoryError = MockInicioRepository(testeSucesso = false)
    }

    @Test
    fun `buscar categorias e comunidades destaques para caso de sucesso`() {
        /** Arrange */
        viewModel = InicioViewModel(repository)
        /** Act */
        viewModel.buscarDestaques()
        /** Assert */
        assertThat(viewModel.categoriasDestaques.getOrAwaitValue().data, `is`(emptyList()))
        assertThat(viewModel.comunidadesDestaques.getOrAwaitValue().data, `is`(emptyList()))
    }

    @Test
    fun `buscar categorias e comunidades destaques quando caso de falha`() {
        /** Arrange */
        viewModel = InicioViewModel(repositoryError)
        /** Act */
        viewModel.buscarDestaques()
        /** Assert */
        assertThat(
            viewModel.categoriasDestaques.getOrAwaitValue().message,
            `is`("Teste unitário erro")
        )
        assertThat(
            viewModel.comunidadesDestaques.getOrAwaitValue().message,
            `is`("Teste unitário erro")
        )
    }

}

class MockInicioRepository(private val testeSucesso: Boolean) : InicioRepository {
    override suspend fun buscarComunidadesDestaques(): Resource<List<Comunidade>> {
        return if (testeSucesso) Resource.Success(emptyList())
        else Resource.Error("Teste unitário erro")
    }
    override suspend fun buscarCategoriasDestaques(): Resource<List<Categoria>> {
        return if (testeSucesso) Resource.Success(emptyList())
        else Resource.Error("Teste unitário erro")
    }
}


