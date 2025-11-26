package com.example.examenjavivaquero

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenjavivaquero.adapter.adapterGasolina
import com.example.examenjavivaquero.databinding.ActivityMainBinding
import com.example.examenjavivaquero.model.Gasolina
import com.example.examenjavivaquero.model.TiposGasolina

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var listaGasolina : ArrayList<TiposGasolina>

    lateinit var adapterGasolina: ArrayAdapter<adapterGasolina>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        acciones()
    }

    private fun instancias() {
        listaGasolina =
            arrayOf(Gasolina("diesel", R.drawable.diesel),
                Gasolina("gasolina", R.drawable.gasolina),
                Gasolina("hibrido", R.drawable.hibrido),
                Gasolina("electrico", R.drawable.electrico))
        adapterGasolina = ArrayAdapter<Gasolina>
    }

    private fun initGUI() {

    }

    private fun acciones() {
        TODO("Not yet implemented")
    }
}