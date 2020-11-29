package com.gitpub.rosatomtasktracker.ui.utils

import android.content.res.ColorStateList
import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.gitpub.rosatomtasktracker.R
import com.gitpub.rosatomtasktracker.model.domain.TaskStatus
import com.gitpub.rosatomtasktracker.model.domain.TaskStatuses


fun TaskStatus.toTextColor(resources: Resources): Int = ResourcesCompat
    .getColor(
        resources,
        when (this) {
            TaskStatuses.New -> R.color.orange
            TaskStatuses.Active -> R.color.blue
            TaskStatuses.Review -> R.color.purple
            TaskStatuses.Closed -> R.color.green
            TaskStatuses.Cancelled -> R.color.red
            else -> R.color.white

        },
        null
    )

fun TaskStatus.toTextBackground(resources: Resources): ColorStateList =
    ColorStateList.valueOf(
        ResourcesCompat
            .getColor(
                resources,
                when (this) {
                    TaskStatuses.New -> R.color.orange_15
                    TaskStatuses.Active -> R.color.blue_15
                    TaskStatuses.Review -> R.color.purple_15
                    TaskStatuses.Closed -> R.color.green_15
                    TaskStatuses.Cancelled -> R.color.red_15
                    else -> R.color.gray2
                },
                null
            )
    )
