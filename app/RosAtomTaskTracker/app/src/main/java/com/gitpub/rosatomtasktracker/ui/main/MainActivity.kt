package com.gitpub.rosatomtasktracker.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.gitpub.rosatomtasktracker.databinding.ActivityMainBinding
import com.gitpub.rosatomtasktracker.ui.utils.viewBinding

class MainActivity : FragmentActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}