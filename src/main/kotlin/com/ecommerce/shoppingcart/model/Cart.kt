package com.ecommerce.shoppingcart.model

import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity(name = "Cart")
data class Cart(

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: UUID = UUID.randomUUID(),

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval=true)
    @Column
    val products: MutableList<Product> = ArrayList(),

    @Column
    var state: String
)