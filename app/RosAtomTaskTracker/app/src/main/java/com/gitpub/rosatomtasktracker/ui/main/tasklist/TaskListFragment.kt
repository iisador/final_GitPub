package com.gitpub.rosatomtasktracker.ui.main.tasklist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.gitpub.rosatomtasktracker.R
import com.gitpub.rosatomtasktracker.databinding.FragmentTaskListBinding
import com.gitpub.rosatomtasktracker.di.DIViewModelProvider
import com.gitpub.rosatomtasktracker.model.items.TaskOfListItem
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.ui.main.MainFragmentDirections
import com.gitpub.rosatomtasktracker.ui.utils.AdapterDelegateRegistry
import com.gitpub.rosatomtasktracker.ui.utils.ItemListAdapter
import com.gitpub.rosatomtasktracker.ui.utils.viewBinding
import org.kodein.di.DIAware
import org.kodein.di.android.x.di

abstract class TaskListFragment : Fragment(R.layout.fragment_task_list), DIAware {

    override val di by di()
    private val binding by viewBinding(FragmentTaskListBinding::bind)

    protected abstract val viewModel: TaskListViewModel

    private val listAdapter = ItemListAdapter().apply {
        addDelegates(AdapterDelegateRegistry.TaskOfList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()
        initializeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

    private fun initializeUi() {
        binding.apply {
            taskList.adapter = listAdapter
        }
    }

    private fun initializeViewModel() {
        viewModel.apply {
            taskList.observe(viewLifecycleOwner) { list ->
                listAdapter.setItemList(
                    when (list) {
                        is Result.Success -> list.data.map {
                            TaskOfListItem.fromTask(it) { task ->
                                navigateToTask(task.id)
                            }
                        }
                        is Result.Error -> emptyList()
                    }
                )
            }
        }
    }

    private fun navigateToTask(id: Long) {
        val action = MainFragmentDirections.actionMainFragmentToTaskPageFragment(id)
        findNavController().navigate(action)
    }
}

class RegularTaskListFragment : TaskListFragment() {

    private val viewModelProvider by lazy { DIViewModelProvider(di) }
    override val viewModel: RegularTaskListViewModel by activityViewModels { viewModelProvider }
}

class IrregularTaskListFragment : TaskListFragment() {

    private val viewModelProvider by lazy { DIViewModelProvider(di) }
    override val viewModel: IrregularTaskListViewModel by activityViewModels { viewModelProvider }
}
