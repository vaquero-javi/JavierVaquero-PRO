package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.ObjectOutputStream
import java.net.Socket

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userTxt = findViewById<EditText>(R.id.userEdit)
        val passTxt = findViewById<EditText>(R.id.passEdit)
        val btnSend = findViewById<Button>(R.id.sendButton)

        btnSend.setOnClickListener {

            val login = Login(
                userTxt.text.toString(),
                passTxt.text.toString()
            )

            Thread {
                try {
                    val socket = Socket("127.0.0.1", 6000) // IP del PC
                    val out = ObjectOutputStream(socket.getOutputStream())
                    out.writeObject(login)
                    out.flush()
                    socket.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }.start()
        }
    }
}
