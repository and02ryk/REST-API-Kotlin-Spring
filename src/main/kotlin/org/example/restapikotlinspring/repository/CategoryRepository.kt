package org.example.restapikotlinspring.repository

import org.example.restapikotlinspring.entity.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Int> {

    fun findByOrderByName(): List<Category>

    fun findByNameStartsWithOrderByName(prefix: String): List<Category>

    fun findAllByOrderByName(): List<Category>
}