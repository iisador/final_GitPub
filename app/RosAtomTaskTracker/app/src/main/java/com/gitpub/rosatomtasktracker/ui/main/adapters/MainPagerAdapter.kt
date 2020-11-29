package com.gitpub.rosatomtasktracker.ui.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gitpub.rosatomtasktracker.ui.main.tasklist.IrregularTaskListFragment
import com.gitpub.rosatomtasktracker.ui.main.tasklist.RegularTaskListFragment
import org.kodein.di.DI
import org.kodein.di.DIAware

class MainPagerAdapter(fragment: Fragment, override val di: DI) :
    FragmentStateAdapter(fragment), DIAware {

    var onCreateFragment: ((Fragment) -> Unit)? = null

    private val fragmentSupplier: (Int) -> Fragment = {
        when (it) {
            0 -> RegularTaskListFragment()
            1 -> IrregularTaskListFragment()
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = fragmentSupplier(position)
        onCreateFragment?.invoke(fragment)
        return fragment
    }
}