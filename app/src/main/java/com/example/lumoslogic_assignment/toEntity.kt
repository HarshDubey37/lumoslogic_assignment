package com.example.lumoslogic_assignment

import com.example.lumoslogic_assignment.data.PostDto
import com.example.lumoslogic_assignment.data.PostEntity
import com.example.lumoslogic_assignment.data.ProductDto
import com.example.lumoslogic_assignment.data.ProductResponse
import com.example.lumoslogic_assignment.domain.Post

fun PostDto.toEntity() = PostEntity(id, title, body)
fun PostEntity.toDomain() = Post(id, title, body)
fun ProductDto.producttoEntity() = PostEntity(id, title, category)