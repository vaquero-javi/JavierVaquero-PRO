package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.databinding.ItemProductoBinding
import com.example.tienda.model.Producto
import com.google.android.material.snackbar.Snackbar

class AdapterProducto(var lista: ArrayList<Producto>, var contexto: Context) : RecyclerView.Adapter<AdapterProducto.MyHolder>() {
    inner class MyHolder(var binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    //crear un holder de la clase anidada
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        var binding: ItemProductoBinding = ItemProductoBinding.inflate(LayoutInflater.from(contexto))
    }

    //aociar los elementos (posicion) con el holder asociado
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val producto: Producto = lista[position]
        holder.binding.textView2.text = producto.nombre
        holder.binding.botonDetalles.setOnClickListener {
            Snackbar.make(holder.binding.root, "La categoria del articulo es  ${producto.categoria}")
        }
        holder.binding.botonLogin.setOnClickListener {
            Snackbar.make(holder.binding.root, "El precio del articulo es ${producto.precio}")
        }
    }

    //cuantos elementos tendre que  pintar
    override fun getItemCount(): Int {
        return lista.size
    }
}