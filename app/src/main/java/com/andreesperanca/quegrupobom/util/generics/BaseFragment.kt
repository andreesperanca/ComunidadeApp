package com.andreesperanca.quegrupobom.util.generics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<V : ViewBinding>(
    private val inflate: (inflater: LayoutInflater) -> V
) : Fragment() {

    private var _binding: V? = null


    protected val binding: V
        get() = _binding as V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate.invoke(inflater)
        if (_binding == null) {
            throw IllegalArgumentException("null binding")
        }

        configureToolbar()

        return binding.root
    }

    abstract fun configureToolbar()
}