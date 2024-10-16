package org.example.restapikotlinspring.controller

import org.example.restapikotlinspring.dto.ProductDto
import org.example.restapikotlinspring.service.ProductService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getAll(): List<ProductDto> =
        productService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): ProductDto =
        productService.findById(id)

    @GetMapping("/search")
    fun searchProducts(@RequestParam("text") prefix: String): List<ProductDto> =
        productService.searchProduct(prefix)

    @PostMapping
    fun create(@RequestBody dto: ProductDto): Int =
        productService.create(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody dto: ProductDto) {
        productService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int) {
        productService.delete(id)
    }
}
