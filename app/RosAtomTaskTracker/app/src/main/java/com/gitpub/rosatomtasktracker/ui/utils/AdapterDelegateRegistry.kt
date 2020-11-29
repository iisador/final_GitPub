package com.gitpub.rosatomtasktracker.ui.utils

import com.gitpub.rosatomtasktracker.ui.main.adapters.TaskCommentAdapterDelegate
import com.gitpub.rosatomtasktracker.ui.main.adapters.TaskOfListAdapterDelegate

object AdapterDelegateRegistry {
    private const val VIEW_TYPE_TASK_OF_LIST = 0x00000000
    private const val VIEW_TYPE_TASK_COMMENT = 0x00000001

    val TaskOfList = VIEW_TYPE_TASK_OF_LIST to TaskOfListAdapterDelegate()
    val TaskComment = VIEW_TYPE_TASK_COMMENT to TaskCommentAdapterDelegate()
}