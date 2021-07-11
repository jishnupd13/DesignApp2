package com.app.mymainapp.dummyuimodels

data class ReturnItemModel(
    val productId:Int?=0,
    var productName:String?="",
    var productColor:String?="",
    var productPrice:Double?=0.0,
    var orderQuantity:Int?=0,
    var returnQuantity:Int?=0
)
