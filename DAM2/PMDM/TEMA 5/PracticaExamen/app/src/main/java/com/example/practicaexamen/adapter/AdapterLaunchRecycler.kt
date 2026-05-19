package com.example.practicaexamen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicaexamen.data.DataSet
import com.example.practicaexamen.databinding.ItemMainBinding
import com.example.practicaexamen.model.Launch


class AdapterLaunchRecycler(var context: Context) :
    RecyclerView.Adapter<AdapterLaunchRecycler.MyHolder>() {

    private var lista = ArrayList<Launch>()

    init {
        lista = ArrayList<Launch>()
    }

    inner class MyHolder(var binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding : ItemMainBinding = ItemMainBinding
            .inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val launch : Launch = lista[position]

        holder.binding.textNombre.text = launch.name
        holder.binding.textDetalle.text = launch.details ?: "No hay detalles disponibles"

        Glide.with(context)
            .load(launch.links.patch?.small)
            .into(holder.binding.imgCard)

        holder.binding.btnFav.setOnClickListener {
            DataSet.addFavorito(launch)
            holder.binding.btnFav.text ="Agregado a favoritos"
        }

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun addLaunch(launch: Launch) {
        lista.add(launch)
        notifyItemInserted(lista.size - 1)
    }

    fun clear() {
        lista.clear()
        notifyDataSetChanged()
    }
}