package com.example.practica.ui.fragment

import androidx.fragment.app.Fragment
import com.example.practica.databinding.FragmentImportacionBinding

class ImportacionFragment : Fragment() {
    private lateinit var binding: FragmentImportacionBinding

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: android.os.Bundle?
    ): android.view.View? {
        binding = FragmentImportacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    //quiero que se importa un json cuando le de al boton importar y se guarde en la base de datos
    override fun onResume() {
        super.onResume()
        binding.btnImportacion.setOnClickListener {

            val json = "https://698949d3c04d974bc69ed0b0.mockapi.io/api/v1/examenes"


        }

    }
}