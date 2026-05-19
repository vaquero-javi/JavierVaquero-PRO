package com.example.myapplication.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRegisterBinding
import com.example.myapplication.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var adapterEdad: ArrayAdapter<Int>
    private lateinit var listaEdades: ArrayList<Int>
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private var nombre : String? = null
    private var pass : String? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)

        database =
            FirebaseDatabase.getInstance("https://database-3e330-default-rtdb.europe-west1.firebasedatabase.app/")
        auth = FirebaseAuth.getInstance()
        listaEdades = ArrayList()
        for (i in 18..50) {
            listaEdades.add(i)
        }
        adapterEdad = ArrayAdapter(context, android.R.layout.simple_spinner_item, listaEdades)
        adapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        nombre = this.arguments?.getString("correo")
        pass = this.arguments?.getString("pass")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        if (nombre != null || pass != null){
            binding.editCorreoRegistro.setText("nombre")
            binding.editPassRegistro.setText("pass")
        }
        binding.spinnerEdadRegistro.adapter = adapterEdad
        binding.btnRegistro.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreoRegistro.text.toString(),
                binding.editPassRegistro.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    Snackbar.make(
                        binding.root,
                        "Usuario registrado correctamente",
                        Snackbar.LENGTH_SHORT).show()
                    val userId = auth.currentUser!!.uid
                    database.reference
                        .child("users")
                        .child(userId).
                        setValue(
                            User(
                                binding.editNombreRegistro.text.toString(),
                                binding.editApellidoRegistro.text.toString(),
                                binding.editCorreoRegistro.text.toString(),
                                binding.spinnerEdadRegistro.selectedItem as Int
                            )
                        )
                    findNavController().navigate(R.id.action_registerFragment_to_dialogRegisterOK)
                }else{
                    findNavController().navigate(R.id.action_registerFragment_to_dialogRegisterFAIL )
                }
            }
        }
        super.onResume()
    }
}