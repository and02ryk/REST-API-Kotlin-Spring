package org.example.restapikotlinspring.entity

import jakarta.persistence.*

@Entity
@Table(name = "product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var name: String = "",
    var price: Float = 0.0F,
    var description: String = "",
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category = Category(),
)