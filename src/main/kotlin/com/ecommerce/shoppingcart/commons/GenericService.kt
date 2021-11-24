package main.kotlin.com.ecommerce.shoppingcart.commons

import java.io.Serializable

interface GenericService<T, ID : Serializable?> {

    fun save(entity: T): T

    fun delete(id: ID)

    operator fun get(id: ID): T?

    val all: MutableList<T>?

}