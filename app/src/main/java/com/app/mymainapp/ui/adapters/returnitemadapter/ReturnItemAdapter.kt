package com.app.mymainapp.ui.adapters.returnitemadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.mymainapp.R
import com.app.mymainapp.databinding.ItemReturnItemBinding
import com.app.mymainapp.dummyuimodels.ReturnItemModel
import com.app.mymainapp.listeners.OnItemClickListener
import timber.log.Timber

class ReturnItemAdapter(val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ReturnItemAdapter.ReturnItemViewHolder>() {


    private val differCallback = object : DiffUtil.ItemCallback<ReturnItemModel>() {
        override fun areItemsTheSame(
            oldItem: ReturnItemModel,
            newItem: ReturnItemModel
        ): Boolean {
            return oldItem.productId == newItem.productId
        }

        override fun areContentsTheSame(
            oldItem: ReturnItemModel,
            newItem: ReturnItemModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    fun submitList(list: List<ReturnItemModel>) {
        differ.submitList(list)
    }


    inner class ReturnItemViewHolder(binding: ItemReturnItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReturnItemViewHolder {
        val itemReturnItemBinding: ItemReturnItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_return_item, parent, false
        )
        return ReturnItemViewHolder(itemReturnItemBinding)
    }

    override fun onBindViewHolder(holder: ReturnItemViewHolder, position: Int) {

        val data = differ.currentList[position]
        holder.itemBinding.listener = onItemClickListener
        holder.itemBinding.item = data
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}