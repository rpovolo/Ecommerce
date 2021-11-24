package com.ecommerce.shoppingcart.model

open class Product (

    var name: String = "",

    var description: String = "",

    var price: Double = 0.0) {
        open fun getDiscount() = price;
}