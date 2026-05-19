package com.example.myapplication.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlin.toString

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        binding.btnLogin.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreoLogin.text.toString(),
                binding.editPassLogin.text.toString()
            ).addOnCompleteListener {
                if ( it.isSuccessful){
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                }else{
                    findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                }
            }
        }
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        super.onResume()
    }
}