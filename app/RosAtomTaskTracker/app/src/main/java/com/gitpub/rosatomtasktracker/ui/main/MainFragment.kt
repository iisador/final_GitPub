package com.gitpub.rosatomtasktracker.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.gitpub.rosatomtasktracker.R
import com.gitpub.rosatomtasktracker.databinding.FragmentMainBinding
import com.gitpub.rosatomtasktracker.ui.main.adapters.MainPagerAdapter
import com.gitpub.rosatomtasktracker.ui.utils.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.kodein.di.DIAware
import org.kodein.di.android.x.di

class MainFragment : Fragment(R.layout.fragment_main), DIAware {

    override val di by di()
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()
    }

    private fun initializeUi() {
        binding.apply {
            viewpager.adapter = MainPagerAdapter(this@MainFragment, di)

            TabLayoutMediator(tabLayout, viewpager) { tab, position ->
                tab.text = getPageTitle(position)
            }.attach()
            toolbar.setOnMenuItemClickListener {
                viewpager.adapter = MainPagerAdapter(this@MainFragment, di)
                true
            }
        }
    }

    private fun getPageTitle(position: Int): CharSequence =
        when (position) {
            0 -> "Регулярные"
            1 -> "Нерегулярные"
            else -> throw IllegalArgumentException()
        }

}
