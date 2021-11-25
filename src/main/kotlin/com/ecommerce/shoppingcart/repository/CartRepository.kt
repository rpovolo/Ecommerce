package com.ecommerce.shoppingcart.repository

import com.ecommerce.shoppingcart.model.Cart
import com.ecommerce.shoppingcart.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CartRepository : JpaRepository<Cart, UUID> {

    @Query("SELECT c.products FROM Cart c where c.id = :idCart")
    fun getProductsFromRepository (idCart: String?) : List<Product>
}