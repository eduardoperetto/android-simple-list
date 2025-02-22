package com.eduardoperetto.simplecrud.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.eduardoperetto.simplecrud.R
import com.eduardoperetto.simplecrud.models.Product
import com.eduardoperetto.simplecrud.ui.recyclerview.ProductListAdapter
import java.math.BigDecimal

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductListAdapter(context = this, products = listOf(
            Product(name = "teste",
                description = "teste desc",
                value = BigDecimal("19.99")
            ),
            Product(name = "teste 1",
                description = "teste desc 1",
                value = BigDecimal("29.99")
            ),
            Product(name = "teste 2",
                description = "teste desc 2",
                value = BigDecimal("39.99")
            ),
        ))
    }

}