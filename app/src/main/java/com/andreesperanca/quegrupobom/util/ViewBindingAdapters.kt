package com.andreesperanca.quegrupobom.util

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter


@BindingAdapter("progressVisibility")
fun progressVisibility(progress: ProgressBar , visible: Boolean) {
    if (visible) progress.visibility = View.VISIBLE
    else progress.visibility = View.INVISIBLE
}