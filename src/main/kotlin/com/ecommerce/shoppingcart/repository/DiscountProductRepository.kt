package com.ecommerce.shoppingcart.repository

import com.ecommerce.shoppingcart.model.DiscountProduct
import com.ecommerce.shoppingcart.model.SimpleProduct
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DiscountProductRepository : CrudRepository<DiscountProduct, Long> {
}