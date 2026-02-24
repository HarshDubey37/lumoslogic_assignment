package com.example.lumoslogic_assignment.data

data class ProductResponse(
    val products: List<ProductDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)