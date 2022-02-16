package com.adrian.epicimagery.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.adrian.epicimagery.R
import com.adrian.epicimagery.databinding.ActivityHomeBinding
import com.adrian.epicimagery.ui.view.fragment.DayListFragment
import com.adrian.epicimagery.ui.view.fragment.ToolbarFragment
import com.adrian.epicimagery.ui.viewmodel.NasaPhotosViewModel
import com.adrian.epicimagery.ui.viewmodel.factory.NasaPhotosViewModelFactory
import com.adrian.epicimagery.utils.extension.viewBinding

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by viewBinding(ActivityHomeBinding::inflate)

    private val viewModel: NasaPhotosViewModel by lazy {
        NasaPhotosViewModelFactory().create(NasaPhotosViewModel::class.java)
    }

    private val toolbarFragment: Fragment by lazy {
        ToolbarFragment()
    }

    private val dayListFragment: Fragment by lazy {
        DayListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setToolbar()
        showDayListFragment()
    }

    private fun setToolbar() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.toolbar_fragment_container, toolbarFragment)
        }
    }

    private fun showDayListFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.screen_fragment_container, dayListFragment)
        }
    }
}