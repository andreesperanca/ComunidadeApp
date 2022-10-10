package com.andreesperanca.quegrupobom.adapters

import android.view.View
import android.widget.AdapterView

class CategoriasSpinnerAdapter(private val action : () -> Unit) : AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val categoria = parent?.getItemAtPosition(position)
        action()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //BUSCAR CATEGORIA MAIS VISITADAS
    }
}
