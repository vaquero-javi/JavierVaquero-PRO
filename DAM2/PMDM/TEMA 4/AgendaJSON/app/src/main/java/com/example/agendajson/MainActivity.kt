package com.example.agendajson

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.model.User
import com.google.gson.Gson
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        realizarPeticionJSON()

    }

    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"
        //1. realizarla peticion
        val peticionJSON: JsonObjectRequest = JsonObjectRequest(
            url,
            {
                val gson = Gson()
                val usersArray: JSONArray = it.getJSONArray("users")
                for(i in 0..usersArray.length()-1){
                    val userJson = usersArray.getJSONObject(i)
                    val user: User = gson.fromJson(userJson.toString(),
                        User::class.java)

                    Log.v("Conexión", "El nombre de usuaruio es ${user.firstName}")
                }
                //Log.v("Conexión", "Los datos se obtienen de forma correcta")
            },
            {
                Log.v("Conexion", "Error en la conexión")
            })
        //2. Añado la peticion a la pila de Volley
        Volley.newRequestQueue(this).add(peticionJSON)
    }
}