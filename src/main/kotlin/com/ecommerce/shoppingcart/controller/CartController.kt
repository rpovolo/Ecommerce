package com.ecommerce.shoppingcart.controller

import com.ecommerce.shoppingcart.model.Cart
import com.ecommerce.shoppingcart.model.Product
import com.ecommerce.shoppingcart.service.CartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
class CartController(private val cartService: CartService) {

    @GetMapping("/all")
    fun getAll(): List<Cart> {
        return cartService.all()
    }

    @PostMapping("/save")
    fun save(@RequestBody simpleCart: Cart): ResponseEntity<Cart> {
        var obj = cartService.save(simpleCart)
        return ResponseEntity<Cart>(obj, HttpStatus.OK)
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Cart> {
        val cart = cartService.get(id)
        if (cart != null) {
            cartService.delete(id)
        } else {
            return ResponseEntity<Cart>(HttpStatus.NO_CONTENT)
        }

        return ResponseEntity<Cart>(cart, HttpStatus.OK)
    }

    @PostMapping("/update")
    fun update(@RequestBody cart: Cart): ResponseEntity<Cart> {
        var obj = cartService.update(cart)
        return ResponseEntity<Cart>(obj, HttpStatus.OK)
    }

    @GetMapping("/allProducts/{id}")
    fun getProductsFromRepository(@PathVariable id: String): ResponseEntity<List<Product>> {
        val products = cartService.getProductsFromRepository(id)
        return ResponseEntity<List<Product>>(products, HttpStatus.OK)
    }

    @PostMapping("/saveProduct/{id}")
    fun saveProduct(@PathVariable id: String, @RequestBody product: List<Product>): ResponseEntity<Cart> {
        var obj = cartService.saveProduct(product,id)
        return ResponseEntity<Cart>(obj, HttpStatus.OK)
    }

}