package com.app.mymainapp.ui.delivery

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.app.mymainapp.databinding.ActivityReturnItemBinding
import com.app.mymainapp.dummyuimodels.ReturnItemModel
import com.app.mymainapp.listeners.OnItemClickListener
import com.app.mymainapp.ui.adapters.returnitemadapter.ReturnItemAdapter
import com.app.mymainapp.utils.hide
import com.app.mymainapp.viewmodels.ReturnItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class ReturnItemActivity : AppCompatActivity(), View.OnClickListener, OnItemClickListener {

    private val binding: ActivityReturnItemBinding by viewBinding()
    private val returnItemViewModel: ReturnItemViewModel by viewModels()

    private val returnItemList = arrayListOf<ReturnItemModel>()

    private var isAnimationVisible=false

    private lateinit var returnItemAdapter: ReturnItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.listener = this
        binding.viewModel = returnItemViewModel
        setUpReturnItemData()



        returnItemAdapter = ReturnItemAdapter(this)
        binding.returnItemRecyclerView.adapter = returnItemAdapter
        returnItemAdapter.submitList(returnItemList)


        binding.nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v?.getChildAt(0)?.measuredHeight?.minus(v.measuredHeight)) {

                Handler(Looper.getMainLooper()).postDelayed(Runnable {
                    toggle()
                }, 400)
            }

            if (scrollY < oldScrollY) {
               binding.layoutPaymentSection.hide()
            }
        })

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.imageBack -> {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(0, 0)
    }

    private fun setUpReturnItemData() {
        returnItemList.add(ReturnItemModel(1, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(2, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(3, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(4, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(5, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(6, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(7, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(8, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(9, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
        returnItemList.add(ReturnItemModel(10, "Tostitos Scoops Spicy", "Black", 6000.0, 17, 1))
    }

    override fun onItemClick(key: String, item: Any) {

    }
    private fun toggle() {


        val transition: Transition = Slide(Gravity.BOTTOM)
        transition.duration = 600
        transition.addTarget(binding.layoutPaymentSection)
        TransitionManager.beginDelayedTransition(binding.root as ViewGroup, transition)
        binding.layoutPaymentSection.visibility = View.VISIBLE



    }
}