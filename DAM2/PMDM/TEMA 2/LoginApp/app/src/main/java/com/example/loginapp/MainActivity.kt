package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.ui.activity.SecondActivity

class MainActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener,
    AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones();
    }

    private fun acciones() {

        binding.botonLogin.setOnClickListener(this)
        binding.botonGit.setOnClickListener(this)
        binding.botonGoogle.setOnClickListener(this)
        binding.botonFacebook.setOnClickListener(this)
        binding.checkRecordar.setOnCheckedChangeListener(this)
        binding.spinnerPerfil.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    binding.botonFacebook.visibility = View.INVISIBLE;
                    binding.botonGit.visibility = View.INVISIBLE;
                    binding.botonGoogle.visibility = View.INVISIBLE;

                    when(position){
                        0->{
                            binding.botonGoogle.visibility = View.VISIBLE;
                        }
                        1->{
                            binding.botonGit.visibility = View.VISIBLE;
                        }
                        2->{
                            binding.botonFacebook.visibility = View.VISIBLE;
                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.botonFacebook.id -> {}
            binding.botonGit.id -> {}
            binding.botonGoogle.id -> {}
            binding.botonLogin.id -> {
                val intent: Intent = Intent(applicationContext,
                    SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCheckedChanged(
        buttonView: CompoundButton,
        isChecked: Boolean
    ) {
        binding.botonLogin.isEnabled = isChecked
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        binding.botonGoogle.visibility = View.INVISIBLE
        binding.botonGit.visibility = View.INVISIBLE
        binding.botonFacebook.visibility = View.INVISIBLE

        when(position){
            0-> {
                binding.botonGoogle.visibility = View.VISIBLE
            }
            1-> {
                binding.botonGit.visibility = View.VISIBLE
            }
            2-> {
                binding.botonFacebook.visibility = View.VISIBLE
            }
            else -> {
                println("No has seleccionado ninguna, por favor seleccione una opción")
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}