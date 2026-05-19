package com.example.exorjaviervaquero.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exorjaviervaquero.adapter.AdapterPostRecycler
import com.example.exorjaviervaquero.databinding.FragmentNoticiasBinding
import com.example.exorjaviervaquero.model.Post
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

class NoticiasFragment : Fragment() {

    private lateinit var binding: FragmentNoticiasBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var adapterPostRecycler: AdapterPostRecycler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase.getInstance("https://exmdata-2b529-default-rtdb.europe-west1.firebasedatabase.app/")
        adapterPostRecycler = AdapterPostRecycler(mutableListOf(), onDetalle = { post ->
            val bundle = Bundle()
            bundle.putSerializable("post", post)
            requireActivity().runOnUiThread {
                //no me dejaba importar mi R y he tenido que hacerlo asi profe, no se si es correcto pero a mi me funciona
                val nav = androidx.navigation.Navigation.findNavController(requireActivity(), com.example.exorjaviervaquero.R.id.nav_host_fragment_content_main)
                nav.navigate(com.example.exorjaviervaquero.R.id.action_noticiasFragment_to_detalleFragment, bundle)

            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNoticiasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.recyclerPosts.adapter = adapterPostRecycler
        binding.recyclerPosts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        cargarDatos()
    }

    private fun cargarDatos() {
        val gson = Gson()
        adapterPostRecycler.update(emptyList())
        database.reference.child("data").get().addOnSuccessListener { snapshot ->
            for (child in snapshot.children) {
                val json = gson.toJson(child.value)
                val postObj = gson.fromJson(json, Post::class.java)
                adapterPostRecycler.addPost(postObj)
            }
        }
    }
}