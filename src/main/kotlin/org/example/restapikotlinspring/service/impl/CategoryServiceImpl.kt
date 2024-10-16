package org.example.restapikotlinspring.service.impl

import org.example.restapikotlinspring.dto.CategoryDto
import org.example.restapikotlinspring.dto.ProductDto
import org.example.restapikotlinspring.entity.Category
import org.example.restapikotlinspring.entity.Product
import org.example.restapikotlinspring.repository.CategoryRepository
import org.example.restapikotlinspring.repository.ProductRepository
import org.example.restapikotlinspring.service.CategoryService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository
) : CategoryService {

    override fun getAll(): List<CategoryDto> =
        categoryRepository.findAll().map { it.toDto() }

    @Transactional
    override fun create(dto: CategoryDto): Int {
        val category = categoryRepository.save(dto.toEntity())
        val products = dto.products.map { it.toEntity(category) }
        productRepository.saveAll(products)
        return category.id
    }

    override fun getCategoryNames(): List<String> =
        categoryRepository.findAllByOrderByName().map { it.name }

    @Transactional
    override fun update(id: Int, dto: CategoryDto) {
        var existingCategory = categoryRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Category not found")

        existingCategory.name = dto.name
        existingCategory.description = dto.description

        existingCategory = categoryRepository.save(existingCategory)

        val products = dto.products.map { it.toEntity(existingCategory) }
        productRepository.deleteAllByCategory(existingCategory)
        productRepository.saveAll(products)
    }

    @Transactional
    override fun delete(id: Int) {
        val existingCategory = categoryRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Category not found")

        productRepository.deleteAllByCategory(existingCategory)
        categoryRepository.deleteById(existingCategory.id)
    }

    override fun findById(id: Int): CategoryDto {
        return categoryRepository.findByIdOrNull(id)?.toDto()
            ?: throw RuntimeException("Category not found")
    }

    override fun search(prefix: String): List<CategoryDto> =
        categoryRepository.findByNameStartsWithOrderByName(prefix)
            .map { it.toDto() }

    private fun Category.toDto(): CategoryDto =
        CategoryDto(
            id = this.id,
            name = this.name,
            description = this.description,
            products = this.products.map { it.toDto() }
        )

    private fun CategoryDto.toEntity(): Category =
        Category(
            id = 0,
            name = this.name,
            description = this.description
        )

    private fun Product.toDto(): ProductDto =
        ProductDto(
            name = this.name,
        )

    private fun ProductDto.toEntity(category: Category): Product =
        Product(
            id = 0,
            name = this.name,
            category = category
        )

}