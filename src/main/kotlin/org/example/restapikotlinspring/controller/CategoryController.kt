package org.example.restapikotlinspring.controller

import org.example.restapikotlinspring.dto.CategoryDto
import org.example.restapikotlinspring.service.CategoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService,
) {

    @GetMapping
    fun getAll(): List<CategoryDto> = categoryService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): CategoryDto =
        categoryService.findById(id)

    @GetMapping("/search")
    fun searchCategories(@RequestParam("text") prefix: String): List<CategoryDto> =
        categoryService.search(prefix)

    @GetMapping("/list")
    fun getCategoryNames(): List<String> = categoryService.getCategoryNames()

    @PostMapping
    fun create(@RequestBody dto: CategoryDto): Int =
        categoryService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody dto: CategoryDto) {
        categoryService.update(id, dto)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: Int) {
        categoryService.delete(id)
    }
}
