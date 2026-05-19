package com.example.practicaexamen.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaexamen.adapter.AdapterLaunchRecycler
import com.example.practicaexamen.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var uid: String

    private lateinit var adapterLaunchRecycler : AdapterLaunchRecycler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser!!.uid
        database = FirebaseDatabase
            .getInstance("https://exmdata-2b529-default-rtdb.europe-west1.firebasedatabase.app/")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.recyclerMain.adapter = adapterLaunchRecycler
        binding.recyclerMain.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        cargarDatos()
    }

    private fun cargarDatos() {
        val gson = Gson()

        database.reference.child("Empresa").get().addOnSuccessListener {
            for (lanzamiento in it.children) {
                val lanzamientoJson = gson.toJson(lanzamiento.value)
                val lanzamientoObj = gson.fromJson(
                    lanzamientoJson,
                    com.example.practicaexamen.model.Launch::class.java
                )
                adapterLaunchRecycler.addLaunch(lanzamientoObj)
            }
        }
    }

}