package com.gitpub.rosatomtasktracker.ui.utils


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.gitpub.rosatomtasktracker.model.items.ListItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

@Suppress("UNCHECKED_CAST")
open class BaseAdapterDelegate<TItem : ListItem, TBinding : ViewBinding>(
    private val itemClass: Class<TItem>,
    private val bindingClass: Class<TBinding>
) : AdapterDelegate<List<ListItem>>() {

    override fun isForViewType(items: List<ListItem>, position: Int): Boolean =
        itemClass.isInstance(items[position])

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder(
            bindingClass.getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            ).invoke(
                null,
                LayoutInflater.from(parent.context),
                parent,
                false
            ) as TBinding
        )

    override fun onBindViewHolder(
        items: List<ListItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val item = items[position] as? TItem ?: return
        val thisHolder = holder as? BaseAdapterDelegate<TItem, TBinding>.ViewHolder ?: return
        val binding = thisHolder.binding
        onBindViewHolder(item, binding)
    }

    protected open fun onBindViewHolder(item: TItem, binding: TBinding) {}

    protected inner class ViewHolder(val binding: TBinding) : RecyclerView.ViewHolder(binding.root)
}