package com.example.examenjavivaquero.model

import java.io.Serializable

class Gasolina (var tipoGasolina: String, var fotoGasolina: Int): Serializable {
    override fun toString(): String {
        return tipoGasolina;
    }
}