package com.ecommerce.shoppingcart.service

import com.ecommerce.shoppingcart.model.Cart
import com.ecommerce.shoppingcart.model.Product
import com.ecommerce.shoppingcart.repository.CartRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Consumer

@Service
class CartService(private val cartRepository: CartRepository) {

    fun save(cart: Cart): Cart {
        return cartRepository.save(cart)
    }

    fun saveProduct(products: List<Product>, idCart : String): Cart {
        val cart = cartRepository.getById(UUID.fromString(idCart))
        cart.products.addAll(products)
        return cartRepository.save(cart)
    }

    fun delete(id: String) {
        cartRepository.deleteById(UUID.fromString(id))
    }

    fun get(id: String): Cart? {
        val obj = cartRepository.findById(UUID.fromString(id))
        return if (obj.isPresent) {
            obj.get()
        } else null
    }

    fun all(): List<Cart> =
         cartRepository.findAll()

    fun update(entity: Cart): Cart {
        return cartRepository.save(entity)
    }

    fun getProductsFromRepository(idCart: String): List<Product> =
        cartRepository.getProductsFromRepository(idCart)
}