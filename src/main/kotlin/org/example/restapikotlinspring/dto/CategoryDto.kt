package org.example.restapikotlinspring.dto

data class CategoryDto(
    val id: Int? = null,
    val name: String,
    val description: String,
    val products: List<ProductDto>,
)
