package com.adrian.epicimagery.utils.extension

import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.adrian.itunesstore.utils.ui.FragmentViewBindingDelegate

/*
* This extension is used with ::inflate and inflate is required to set the content view
 */
inline fun <T: ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}

/*
* this extension is used with ::bind and bind is used to map values to an already created view
 */
fun <T:ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)