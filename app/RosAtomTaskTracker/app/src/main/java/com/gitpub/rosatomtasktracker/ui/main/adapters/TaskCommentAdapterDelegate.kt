package com.gitpub.rosatomtasktracker.ui.main.adapters

import android.content.res.ColorStateList
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import com.gitpub.rosatomtasktracker.R
import com.gitpub.rosatomtasktracker.databinding.ViewTaskCommentBinding
import com.gitpub.rosatomtasktracker.model.items.TaskCommentItem
import com.gitpub.rosatomtasktracker.ui.utils.BaseAdapterDelegate
import com.gitpub.rosatomtasktracker.ui.utils.createAttachmentView

class TaskCommentAdapterDelegate : BaseAdapterDelegate<TaskCommentItem, ViewTaskCommentBinding>(
    TaskCommentItem::class.java,
    ViewTaskCommentBinding::class.java
) {
    override fun onBindViewHolder(item: TaskCommentItem, binding: ViewTaskCommentBinding) {
        super.onBindViewHolder(item, binding)
        binding.apply {
            name.text = item.authorName
            timeCreated.text = item.createdAt.toString("HH:MM")
            dateCreated.text = item.createdAt.toString("dd MMM yyyy")
            commentBody.text = item.commentBody

            attachmentsContainer.removeAllViews()
            item.attachments?.map { it.createAttachmentView(root.context) }
                .also { attachmentsContainer.isVisible = !it.isNullOrEmpty() }
                ?.forEach(attachmentsContainer::addView)

            answer.setOnClickListener { item.onAnswer(item) }
            container.backgroundTintList = ColorStateList.valueOf(
                ResourcesCompat.getColor(
                    root.resources,
                    if (item.isClosing) R.color.blue_15 else R.color.white,
                    null
                )
            )
        }
    }
}