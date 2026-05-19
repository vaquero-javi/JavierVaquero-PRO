package com.example.exorjaviervaquero.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exorjaviervaquero.databinding.FragmentDetalleBinding
import com.example.exorjaviervaquero.model.Post
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

class DetalleFragment : Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    private lateinit var database: FirebaseDatabase
    private var post: Post? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase.getInstance("https://exmdata-2b529-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val gson = Gson()
        post = arguments?.getSerializable("post") as? Post
        post?.let { p ->
            binding.textTitleDetalle.text = p.title
            binding.textBodyDetalle.text = p.body
            binding.textLikes.text = p.reactions.likes.toString()
            binding.textDislikes.text = p.reactions.dislikes.toString()
            binding.textViews.text = "Views: ${p.views}"

            database.reference.child("data").get().addOnSuccessListener { snapshot ->
                for (child in snapshot.children) {
                    val json = gson.toJson(child.value)
                    val postObj = gson.fromJson(json, Post::class.java)
                    if (postObj.id == p.id) {
                        val newViews = postObj.views + 1
                        child.ref.child("views").setValue(newViews)
                        binding.textViews.text = "Views: $newViews"
                        break
                    }
                }
            }

            binding.btnLike.setOnClickListener {
                val current = binding.textLikes.text.toString().toLongOrNull() ?: 0L
                binding.textLikes.text = (current + 1).toString()
            }

            binding.btnDislike.setOnClickListener {
                val current = binding.textDislikes.text.toString().toLongOrNull() ?: 0L
                binding.textDislikes.text = (current + 1).toString()
            }
        }
    }
}