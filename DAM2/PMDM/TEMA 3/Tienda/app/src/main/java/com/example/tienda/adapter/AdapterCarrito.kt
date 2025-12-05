package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ItemCarritoBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto

class AdapterCarrito(
    private var listaCarrito: ArrayList<Producto>,
    private val contexto: Context,
    private val onTotalChanged: (Double) -> Unit
) : RecyclerView.Adapter<AdapterCarrito.MyHolder>() {

    inner class MyHolder(var binding: ItemCarritoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemCarritoBinding.inflate(
            LayoutInflater.from(contexto),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = listaCarrito[position]

        Glide.with(contexto)
            .load(producto.imagen)
            .placeholder(R.drawable.producto)
            .into(holder.binding.imagenCarrito)

        holder.binding.nombreCarrito.text = producto.nombre
        holder.binding.precioCarrito.text = "${producto.precio} €"

        // Botón para eliminar del carrito
        holder.binding.btnEliminar.setOnClickListener {
            listaCarrito.removeAt(position)
            notifyItemRemoved(position)
            calcularTotal()
        }
    }

    override fun getItemCount(): Int = listaCarrito.size

    private fun calcularTotal() {
        val total = listaCarrito.sumOf { it.precio }
        onTotalChanged(total)
    }

    init {
        calcularTotal() // Calcular total inicial
    }
}