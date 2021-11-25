package com.ecommerce.shoppingcart.controller

import com.ecommerce.shoppingcart.model.Product
import com.ecommerce.shoppingcart.service.CartService
import com.ecommerce.shoppingcart.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
class ProductController (private val productService: ProductService){

    @GetMapping("/all")
    fun getAll() : List<Product>? {
        return productService.all()
    }

    @PostMapping("/save")
    fun save(@RequestBody simpleProduct: Product) : ResponseEntity<Product> {
        var obj = productService.save(simpleProduct)
        return ResponseEntity<Product>(obj, HttpStatus.OK)
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: String) : ResponseEntity<Product> {
        val product = productService.get(id)
        if (product != null) {
            productService.delete(id)
        } else {
            return ResponseEntity<Product>(HttpStatus.NO_CONTENT)
        }

        return ResponseEntity<Product>(product, HttpStatus.OK)
    }

    @PostMapping("/update")
    fun update(@RequestBody simpleProduct: Product) : ResponseEntity<Product> {
        var obj = productService.update(simpleProduct)
        return ResponseEntity<Product>(obj, HttpStatus.OK)
    }


}