package com.eduardoperetto.simplecrud.models

import java.math.BigDecimal

data class Product(
    val name: String,
    val description: String,
    val value: BigDecimal
)