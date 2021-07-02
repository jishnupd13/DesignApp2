package com.app.mymainapp.dummyuimodels

data class OrderListModel(
    val orderId: Int,
    val orderUserId: String,
    val userName: String,
    val orderAddress: String,
    val orderPay: String,
    val orderStatus: OrderStatus
)