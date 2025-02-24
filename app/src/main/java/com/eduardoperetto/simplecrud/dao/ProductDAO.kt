package com.eduardoperetto.simplecrud.dao

import com.eduardoperetto.simplecrud.models.Product

class ProductDAO {
    companion object {
        private val products = mutableListOf<Product>()
    }

    fun add(product: Product) {
        products += product
    }

    fun fetch(): List<Product> = products.toList()
}