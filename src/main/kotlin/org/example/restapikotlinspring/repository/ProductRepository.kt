package org.example.restapikotlinspring.repository

import org.example.restapikotlinspring.entity.Category
import org.example.restapikotlinspring.entity.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Int> {

    fun deleteAllByCategory(category: Category)

    fun findByNameStartsWithOrderByName(prefix: String): List<Product>

}