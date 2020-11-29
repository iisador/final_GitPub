package com.gitpub.rosatomtasktracker.ui.utils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gitpub.rosatomtasktracker.R
import com.gitpub.rosatomtasktracker.model.domain.Attachment


fun Float.pxAsDp(metrics: DisplayMetrics) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    metrics
).toInt()

infix fun View.pxAsDp(px: Float) = px.pxAsDp(resources.displayMetrics)

fun Attachment.createAttachmentView(context: Context) =
    ImageView(context).apply {
        layoutParams = LinearLayout.LayoutParams(
            pxAsDp(128f),
            pxAsDp(128f)
        ).also {
            it.setMargins(0, 0, pxAsDp(16f), 0)
        }
        scaleType = ImageView.ScaleType.CENTER_CROP
        contentDescription = name

        Glide
            .with(this)
            .load(url)
            .transform(CenterCrop(), RoundedCorners(pxAsDp(4f)))
            .fallback(R.mipmap.attachment_placeholder)
            .placeholder(R.mipmap.attachment_placeholder)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
