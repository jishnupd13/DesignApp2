package com.app.mymainapp.ui.adapters.orders

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.mymainapp.R
import com.app.mymainapp.databinding.ItemOrderListBinding
import com.app.mymainapp.dummyuimodels.OrderListModel
import com.app.mymainapp.dummyuimodels.OrderStatus
import com.app.mymainapp.listeners.OnItemClickListener

class OrdersAdapter(val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    inner class OrdersViewHolder(binding: ItemOrderListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemBinding = binding
    }

    private val differCallback = object : DiffUtil.ItemCallback<OrderListModel>() {
        override fun areItemsTheSame(
            oldItem: OrderListModel,
            newItem: OrderListModel
        ): Boolean {
            return oldItem.orderId == newItem.orderId
        }

        override fun areContentsTheSame(
            oldItem: OrderListModel,
            newItem: OrderListModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    fun submitList(list: List<OrderListModel>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val itemOrderListBinding: ItemOrderListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_order_list, parent, false
        )
        return OrdersViewHolder(itemOrderListBinding)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        val data = differ.currentList[position]
        val binding = holder.itemBinding
        binding.item=data
        when (data.orderStatus) {

            OrderStatus.PAID -> {
                binding.textPaymentStatus.setTextColor(Color.parseColor("#1BA400"))
                binding.textPaymentStatus.text="Paid"
                binding.textPaymentStatus.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_paid,
                    0,
                    0,
                    0
                )
            }

            OrderStatus.CREDIT -> {
                binding.textPaymentStatus.setTextColor(Color.parseColor("#ED7E0F"))
                binding.textPaymentStatus.text="Credit"
                binding.textPaymentStatus.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_credit,
                    0,
                    0,
                    0
                )

            }

            OrderStatus.COD -> {
                binding.textPaymentStatus.setTextColor(Color.parseColor("#C31A1A"))
                binding.textPaymentStatus.text="COD"
                binding.textPaymentStatus.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_cod,
                    0,
                    0,
                    0
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}