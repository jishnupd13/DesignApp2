package com.app.mymainapp.ui.delivery

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.mymainapp.R
import com.app.mymainapp.databinding.FragmentDeliveryBinding
import com.app.mymainapp.dummyuimodels.OrderListModel
import com.app.mymainapp.dummyuimodels.OrderStatus
import com.app.mymainapp.listeners.ActivityListeners
import com.app.mymainapp.listeners.OnItemClickListener
import com.app.mymainapp.ui.adapters.orders.OrdersAdapter
import com.app.mymainapp.viewmodels.DeliveryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DeliveryFragment(val activityListeners: ActivityListeners) :
    Fragment(R.layout.fragment_delivery), View.OnClickListener,
    OnItemClickListener {

    private val binding: FragmentDeliveryBinding by viewBinding()
    private val deliveryViewModel: DeliveryViewModel by viewModels()
    private val orderList = arrayListOf<OrderListModel>()

    private lateinit var adapterOrdersAdapter: OrdersAdapter

    private var isVisibleOptions = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener = this
        binding.viewModel = deliveryViewModel

        adapterOrdersAdapter = OrdersAdapter(this)
        binding.orderRecyclerView.adapter = adapterOrdersAdapter
        setUpOrder()
        adapterOrdersAdapter.submitList(orderList)

    }

    override fun onClick(view: View?) {
        when (view) {
            binding.imageOptions -> {
                activityListeners.visibleOptions()
            }
        }
    }

    private fun setUpOrder() {
        orderList.add(
            OrderListModel(
                1,
                "Order ID - FM63862",
                "Ronny John",
                "Chembakam (H), Nalukettu Road, PO Koratty",
                "₹ 1200",
                OrderStatus.PAID
            )
        )
        orderList.add(
            OrderListModel(
                2,
                "Order ID - FM63862",
                "Ronny John",
                "Chembakam (H), Nalukettu Road, PO Koratty",
                "₹ 1200",
                OrderStatus.COD
            )
        )
        orderList.add(
            OrderListModel(
                3,
                "Order ID - FM63862",
                "Ronny John",
                "Chembakam (H), Nalukettu Road, PO Koratty",
                "₹ 1200",
                OrderStatus.CREDIT
            )
        )
        orderList.add(
            OrderListModel(
                4,
                "Order ID - FM63862",
                "Ronny John",
                "Chembakam (H), Nalukettu Road, PO Koratty",
                "₹ 1200",
                OrderStatus.PAID
            )
        )
    }

    override fun onItemClick(key: String, item: Any) {

        when(key){
            "root"->{
                val deliveryIntent= Intent(context,OrderDetailsActivity::class.java)
                startActivity(deliveryIntent)
            }
        }
    }


}