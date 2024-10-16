package org.example.restapikotlinspring.service

import org.example.restapikotlinspring.dto.ProductDto

interface ProductService {

    fun getAll(): List<ProductDto>

    fun findById(id: Int): ProductDto

    fun searchProduct(prefix: String): List<ProductDto>

    fun create(dto: ProductDto): Int

    fun update(id: Int, dto: ProductDto)

    fun delete(id: Int)
}