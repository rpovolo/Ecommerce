package com.ecommerce.shoppingcart.model


import javax.persistence.*

@Entity(name = "SimpleProduct")
class SimpleProduct : Product (

) {
    @Id
    @Column(name = "sku", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var sku: Long? = null

}