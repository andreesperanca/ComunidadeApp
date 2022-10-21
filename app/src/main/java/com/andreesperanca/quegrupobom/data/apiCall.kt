package com.andreesperanca.quegrupobom.data

inline fun <T> apiCall(action: () -> Resource<T>): Resource<T> {
    return try {
        action()
    } catch (e: Exception) {
        Resource.Error(e.message ?: "")
    }
}