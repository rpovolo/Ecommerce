package com.ecommerce.shoppingcart.controller

import com.ecommerce.shoppingcart.api.SimpleProductServiceAPI
import com.ecommerce.shoppingcart.model.SimpleProduct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
class ProductController {

    @Autowired
    lateinit var simpleProductServiceAPI: SimpleProductServiceAPI

    @GetMapping("/all")
    fun getAll() : MutableList<SimpleProduct>? {
        return simpleProductServiceAPI.all
    }

}