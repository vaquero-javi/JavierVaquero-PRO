package com.example.tienda.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tienda.databinding.ActivitySecondBinding
import com.example.tienda.model.Producto

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val producto = intent.getSerializableExtra("Producto") as? Producto

        if (producto != null){
            mostrarDetalles(producto)
        }else{
            finish()
        }

        binding.botonAtrasDetalle.setOnClickListener {
            finish()
        }

    }

    private fun mostrarDetalles(producto: Producto){
        binding.nombreDetalle.text = producto.nombre
        binding.precioDetalle.text ="Precio: ${producto.precio}"
        binding.stockDetalle.text = "Stock: ${producto.stock}"
        binding.categoriaDetalle.text = "Categoría: ${producto.categoria}"
        binding.descripcionDetalle.text = "Descripcion: ${producto.descripcion}"


    }
}