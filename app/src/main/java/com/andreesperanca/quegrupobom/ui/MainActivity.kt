package com.andreesperanca.quegrupobom.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andreesperanca.quegrupobom.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //    val txtWatcher: EditText
//        get() = binding.customToolbar
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}