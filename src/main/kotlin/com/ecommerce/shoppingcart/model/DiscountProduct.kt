package com.ecommerce.shoppingcart.model

import javax.persistence.*

@Entity(name = "DiscountProduct")
class DiscountProduct : Product (

) {
    @Id
    @Column(name = "sku", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var sku: Long? = null

    override fun getDiscount(): Double {
        return super.getDiscount() / 2
    }

}