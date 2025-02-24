package com.eduardoperetto.simplecrud.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eduardoperetto.simplecrud.R
import com.eduardoperetto.simplecrud.dao.ProductDAO
import com.eduardoperetto.simplecrud.models.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_product_form_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupButton()
    }

    private fun setupButton() {
        val saveButton = findViewById<Button>(R.id.activity_product_form_saveButton)
        saveButton.setOnClickListener { onSave() }
    }

    private fun onSave() {
        val product = getProductFromView()
        ProductDAO().add(product)
        this.finish()
    }

    private fun getProductFromView(): Product {
        val productName = findViewById<EditText>(R.id.activity_product_form_name).text.toString()
        val description = findViewById<EditText>(R.id.activity_product_form_description).text.toString()
        val decimalValue = getDecimalValueFromView()
        val product = Product(
            productName, description, decimalValue
        )
        return product
    }

    private fun getDecimalValueFromView(): BigDecimal {
        val valueStr = findViewById<EditText>(R.id.activity_product_form_value).text.toString()
        val decimalValue = if (valueStr.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valueStr)
        }
        return decimalValue
    }
}