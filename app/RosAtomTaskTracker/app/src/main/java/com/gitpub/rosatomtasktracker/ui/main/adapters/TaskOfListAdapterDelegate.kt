package com.gitpub.rosatomtasktracker.ui.main.adapters

import androidx.core.view.isVisible
import com.gitpub.rosatomtasktracker.databinding.ViewTaskOfListBinding
import com.gitpub.rosatomtasktracker.model.items.TaskOfListItem
import com.gitpub.rosatomtasktracker.ui.utils.BaseAdapterDelegate
import com.gitpub.rosatomtasktracker.ui.utils.toTextBackground
import com.gitpub.rosatomtasktracker.ui.utils.toTextColor

class TaskOfListAdapterDelegate : BaseAdapterDelegate<TaskOfListItem, ViewTaskOfListBinding>(
    TaskOfListItem::class.java,
    ViewTaskOfListBinding::class.java
) {
    override fun onBindViewHolder(item: TaskOfListItem, binding: ViewTaskOfListBinding) {
        super.onBindViewHolder(item, binding)
        binding.apply {
            title.text = item.title
            status.apply {
                text = item.status.code
                setTextColor(item.status.toTextColor(resources))
                backgroundTintList = item.status.toTextBackground(resources)
            }
            type.text = item.type.code
            priority.isVisible = item.isUrgent
            timeCreated.text = item.dateTimeCreated.toString("HH:MM")
            dateCreated.text = item.dateTimeCreated.toString("dd MMM yyyy")

            root.setOnClickListener { item.onClick(item) }
        }
    }

}