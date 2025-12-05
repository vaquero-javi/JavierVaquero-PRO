package com.example.tienda.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogoInformacion : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: androidx.appcompat.app.AlertDialog.Builder =
            androidx.appcompat.app.AlertDialog.Builder(requireContext())

        builder.setTitle("Informacion de la APP")
        builder.setMessage("Esta app ha sido realizada para analizar datos recycler view")

        builder.setTitle("Informacion de la APP")
        builder.setMessage("Esta APP ha sido realizada para analizar datos del recycler view")
        builder.setPositiveButton("OK", {_, _->{
            Log.v("dialogo","Pulsado el boton positivo")
        }})
        builder.setNegativeButton("NO", {_, _->{
            Log.v("dialogo","Pulsado el boton negativo")
        }})
        builder.setNeutralButton("CANCEL", {_, _->{
            Log.v("dialogo","Pulsado el boton cancelar")
        }})

        return builder.create()
    }

}