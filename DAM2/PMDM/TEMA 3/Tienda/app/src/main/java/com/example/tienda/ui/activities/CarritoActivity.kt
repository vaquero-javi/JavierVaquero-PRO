package com.example.tienda.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterCarrito
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.dataset.DataSet
import com.google.android.material.snackbar.Snackbar

class CarritoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterCarrito: AdapterCarrito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Configurar RecyclerView
        adapterCarrito = AdapterCarrito(
            DataSet.Companion.listaCarrito,
            this
        ) { total ->
            // Actualizar total cuando cambie
            binding.totalCarrito.text = "Total: ${String.format("%.2f", total)} €"
        }

        binding.recyclerCarrito.layoutManager = LinearLayoutManager(this)
        binding.recyclerCarrito.adapter = adapterCarrito

        // Botón de compra
        binding.btnComprar.setOnClickListener {
            if (DataSet.Companion.listaCarrito.isEmpty()) {
                Snackbar.make(binding.root, "El carrito está vacío", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, "Compra realizada con éxito", Snackbar.LENGTH_LONG)
                    .setAction("OK") { finish() }
                    .show()
                DataSet.Companion.listaCarrito.clear()
                adapterCarrito.notifyDataSetChanged()
                binding.totalCarrito.text = "Total: 0.00 €"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}