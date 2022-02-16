package com.adrian.epicimagery.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adrian.epicimagery.ui.viewmodel.NasaPhotosViewModel
import java.lang.IllegalArgumentException

class NasaPhotosViewModelFactory: ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NasaPhotosViewModel::class.java)) {
            NasaPhotosViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}