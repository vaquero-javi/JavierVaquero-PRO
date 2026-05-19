package com.example.exorjaviervaquero.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exorjaviervaquero.R
import com.example.exorjaviervaquero.model.Post

class AdapterPostRecycler(
    private var items: MutableList<Post>,
    private val onDetalle: (Post) -> Unit
) : RecyclerView.Adapter<AdapterPostRecycler.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle: TextView = view.findViewById(R.id.textTitle)
        val textTag: TextView = view.findViewById(R.id.textTag)
        val btnDetalle: Button = view.findViewById(R.id.btnDetalle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = items[position]
        holder.textTitle.text = post.title
        holder.textTag.text = if (post.tags.isNotEmpty()) post.tags[0] else ""
        holder.btnDetalle.setOnClickListener { onDetalle(post) }
    }

    override fun getItemCount(): Int = items.size

    fun update(newItems: List<Post>) {
        items = newItems.toMutableList()
        notifyDataSetChanged()
    }

    fun addPost(post: Post) {
        items.add(post)
        notifyItemInserted(items.size - 1)
    }

    fun addPosts(posts: List<Post>) {
        val start = items.size
        items.addAll(posts)
        notifyItemRangeInserted(start, posts.size)
    }
}