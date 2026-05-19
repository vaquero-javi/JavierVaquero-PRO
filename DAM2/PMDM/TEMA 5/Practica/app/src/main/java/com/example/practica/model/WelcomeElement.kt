package com.example.practica.model

import java.io.Serializable

data class WelcomeElement (
    val titulo: String,
    val tema: String,
    val detalle: String,
    val dificultad: String,
    val id: String
): Serializable