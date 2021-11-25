package com.ecommerce.shoppingcart.service

import com.ecommerce.shoppingcart.model.Cart
import com.ecommerce.shoppingcart.model.Product
import com.ecommerce.shoppingcart.repository.CartRepository
import com.ecommerce.shoppingcart.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun save(cart: Product): Product {
        return productRepository.save(cart)
    }

    fun delete(id: String) {
        productRepository.deleteById(UUID.fromString(id))
    }

    fun get(id: String): Product? {
        val obj = productRepository.findById(UUID.fromString(id))
        return if (obj.isPresent) {
            obj.get()
        } else null
    }

    fun all(): List<Product> =
        productRepository.findAll()

    fun update(entity: Product): Product {
        return productRepository.save(entity)
    }

}