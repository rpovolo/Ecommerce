package com.ecommerce.shoppingcart.service

import com.ecommerce.shoppingcart.api.SimpleProductServiceAPI
import com.ecommerce.shoppingcart.commons.GenericServiceImpl
import com.ecommerce.shoppingcart.model.SimpleProduct
import com.ecommerce.shoppingcart.repository.SimpleProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class SimpleProductService : GenericServiceImpl<SimpleProduct, Long>(), SimpleProductServiceAPI {

    @Autowired
    lateinit var simpleProductRepository: SimpleProductRepository

    override val dao: CrudRepository<SimpleProduct, Long>
        get() {
            return simpleProductRepository
        }
}