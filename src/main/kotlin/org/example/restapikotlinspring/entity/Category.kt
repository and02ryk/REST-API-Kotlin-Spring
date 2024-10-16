package org.example.restapikotlinspring.entity

import jakarta.persistence.*

@Entity
@Table(name = "category")
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var name: String = "",
    var description: String = "",
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    var products: List<Product> = emptyList(),
)