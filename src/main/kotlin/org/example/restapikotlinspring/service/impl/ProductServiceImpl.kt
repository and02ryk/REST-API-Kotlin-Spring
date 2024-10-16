package org.example.restapikotlinspring.service.impl

import org.example.restapikotlinspring.dto.ProductDto
import org.example.restapikotlinspring.entity.Product
import org.example.restapikotlinspring.repository.ProductRepository
import org.example.restapikotlinspring.service.ProductService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    fun updatePrices() {
        val products: Iterable<Product> = productRepository.findAll()
        products.forEach { product ->
            product.price += 1
            productRepository.save(product)
        }
    }

    override fun getAll(): List<ProductDto> =
        productRepository.findAll().map { it.toDto() }


    override fun findById(id: Int): ProductDto =
        productRepository.findByIdOrNull(id)?.toDto()
            ?: throw RuntimeException("Category not found")

    override fun searchProduct(prefix: String): List<ProductDto> =
        productRepository.findByNameStartsWithOrderByName(prefix)
            .map { it.toDto() }

    override fun create(dto: ProductDto): Int {
        return productRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: ProductDto) {
        var existingProduct = productRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Product not found")

        existingProduct.name = dto.name

        productRepository.save(existingProduct)
    }

    override fun delete(id: Int) {
        var existingProduct = productRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Product not found")

        productRepository.delete(existingProduct)
    }


    private fun Product.toDto(): ProductDto =
        ProductDto(
            name = this.name,
        )

    private fun ProductDto.toEntity(): Product =
        Product(
            id = 0,
            name = this.name,
        )
}