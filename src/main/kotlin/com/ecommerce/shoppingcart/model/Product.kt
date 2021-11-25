package com.ecommerce.shoppingcart.model


import java.util.*
import javax.persistence.*

@Entity(name = "Product")
data class Product(

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "sku", nullable = false)
    val sku: UUID = UUID.randomUUID(),

    @Column
    var name: String,

    @Column
    var description: String,

    @Column
    var price: Double,

    @Column
    var PercentageDiscount: Double,

    @Column
    var category: String
)