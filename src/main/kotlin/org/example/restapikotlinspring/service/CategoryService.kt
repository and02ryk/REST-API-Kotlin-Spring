package org.example.restapikotlinspring.service

import org.example.restapikotlinspring.dto.CategoryDto

interface CategoryService {

    fun getAll(): List<CategoryDto>

    fun findById(id: Int): CategoryDto

    fun search(prefix: String): List<CategoryDto>

    fun getCategoryNames(): List<String>

    fun create(dto: CategoryDto): Int

    fun update(id: Int, dto: CategoryDto)

    fun delete(id: Int)
}