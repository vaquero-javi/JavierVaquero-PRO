package com.example.tienda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.model.Producto

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProducto: AdapterProducto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lista: ArrayList<Producto> = arrayListOf(
            Producto(1, "Nombre1", 12, 10.0, "descripcion1", "categoria1", "img1"),
            Producto(2, "Nombre2", 12, 10.0, "descripcion2", "categoria2", "img2")
        )
        adapterProducto = AdapterProducto(lista, this)

        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager == LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, false
            )
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)

        }
        //LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerProductos.adapter = adapterProducto

    }
}