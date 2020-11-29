package com.gitpub.rosatomtasktracker.ui.utils

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gitpub.rosatomtasktracker.model.items.ListItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager


class ItemListAdapter(items: List<ListItem> = listOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mItemList = mutableListOf<ListItem>().apply {
        items.forEach { this.add(it) }
    }
    private val mDelegatesManager = AdapterDelegatesManager<List<ListItem>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        mDelegatesManager.onCreateViewHolder(parent, viewType)

    override fun getItemCount(): Int = mItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mDelegatesManager.onBindViewHolder(mItemList, position, holder)
    }

    fun addDelegate(viewType: Int, delegate: AdapterDelegate<List<ListItem>>) {
        mDelegatesManager.addDelegate(viewType, delegate)
    }

    fun addDelegates(vararg delegates: Pair<Int, AdapterDelegate<List<ListItem>>>) {
        delegates.forEach { mDelegatesManager.addDelegate(it.first, it.second) }
    }

    override fun getItemViewType(position: Int): Int {
        return mDelegatesManager.getItemViewType(mItemList, position)
    }

    fun setItemList(items: List<ListItem>) {
        mItemList.clear()
        items.forEach { mItemList.add(it) }
        notifyDataSetChanged()
    }
}