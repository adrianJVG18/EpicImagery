package com.adrian.epicimagery.ui.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.adrian.epicimagery.R
import com.adrian.epicimagery.databinding.FragmentToolbarBinding
import com.adrian.epicimagery.utils.extension.viewBinding

class ToolbarFragment: Fragment(R.layout.fragment_toolbar) {

    private val binding: FragmentToolbarBinding by viewBinding(FragmentToolbarBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playButton.setOnClickListener {
            // TODO
        }
    }

    fun setToolbarTitle(title: String) {
        binding.toolbarTextview.text = title
    }

    fun handleVisibility(isVisible: Boolean) {
        binding.toolbarContainer.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}