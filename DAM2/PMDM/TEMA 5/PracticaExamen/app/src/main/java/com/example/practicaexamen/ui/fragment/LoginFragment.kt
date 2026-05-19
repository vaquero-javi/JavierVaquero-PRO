package com.example.practicaexamen.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practicaexamen.R
import com.example.practicaexamen.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


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
        super.onResume()

        binding.btnLogin.setOnClickListener {
            val email = binding.editCorreoLogin.text.toString()
            val pass = binding.editPassLogin.text.toString()

            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener { loginTask ->
                    if (loginTask.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                    } else {
                        auth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener { registerTask ->
                                if (registerTask.isSuccessful) {
                                    Snackbar
                                        .make(
                                            binding.root,
                                            "Cuenta creada. Pulsa para iniciar sesión",
                                            Snackbar.LENGTH_LONG)
                                        .setAction("Iniciar sesión") {
                                            auth.signInWithEmailAndPassword(email, pass)
                                                .addOnCompleteListener { secondLoginTask ->
                                                    if (secondLoginTask.isSuccessful) {
                                                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                                                    } else {
                                                        Snackbar.make(
                                                            binding.root,
                                                            "No se pudo iniciar sesión ",
                                                            Snackbar.LENGTH_LONG
                                                        ).show()
                                                    }
                                                }
                                        }
                                        .show()
                                }
                            }
                    }
                }
        }
    }

}