package com.eduardoperetto.simplecrud.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.eduardoperetto.simplecrud.R
import com.eduardoperetto.simplecrud.dao.ProductDAO
import com.eduardoperetto.simplecrud.ui.recyclerview.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity(R.layout.activity_product_list) {

    private val productDAO = ProductDAO()
    private val adapter = ProductListAdapter(context = this, products = productDAO.fetch())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButton()
        setupListAdapter()
    }

    override fun onResume() {
        super.onResume()
        adapter.setProducts(productDAO.fetch())
    }

    private fun setupButton() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_product_list_fab)
        fab.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupListAdapter() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_product_list_recyclerView)
        recyclerView.adapter = adapter
    }

}