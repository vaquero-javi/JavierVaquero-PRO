package com.example.tienda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.activities.CarritoActivity
import com.example.tienda.ui.dialogs.DialogoInformacion
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),
    AdapterProducto.OnProductoCarritoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProducto: AdapterProducto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val lista: ArrayList<Producto> = DataSet.lista
        // quiero obtener la lista de productos de una categoria determinada
        // categoria

        adapterProducto = AdapterProducto(lista, this)

        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL, false
                )
        } else {

            binding.recyclerProductos.layoutManager =
                GridLayoutManager(
                    this, 2,
                    GridLayoutManager.VERTICAL, false
                )
        }
        binding.recyclerProductos.adapter = adapterProducto;

        acciones()


    }

    fun acciones() {
       /* binding.spinnerCategorias.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    var categoriaSeleccionada = parent!!.adapter.getItem(position)
                    var listaFiltrada = DataSet.getListaFiltrada(categoriaSeleccionada.toString())
                    adapterProducto.chageList(listaFiltrada)
                    // adapterProducto = AdapterProducto(listaFiltrada, this@MainActivity)
                    // binding.recyclerProductos.adapter = adapterProducto;
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            // ver la activity del carrito
            R.id.menu_carrio->{
                val intent = Intent(this, CarritoActivity::class.java)
                startActivity(intent)
                return true
            }
            // fitrar la lista (no se filtra por el cambio)
            R.id.menu_filtrar->{
                // Mostrar un diálogo para filtrar
                mostrarDialogoFiltro()
                return true
            }
            // quito el filtro de la lista, y pongo todos los elementos
            R.id.menu_limpiar->{
                // Restaurar lista completa
                adapterProducto.chageList(DataSet.lista)
                Snackbar.make(binding.root, "Filtro eliminado", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_info->{
                val dialogoInformacion: DialogoInformacion = DialogoInformacion()
                dialogoInformacion.show(supportFragmentManager,null)
            }
        }
        return true;
    }

    override fun actualizarContadorCarrito() {
        binding.textoContador.text = DataSet.listaCarrito.size.toString()
    }

    // Para mostrar diálogo de filtro
    private fun mostrarDialogoFiltro() {
        val categorias = arrayOf("Todas", "muebles", "tecnologia", "ropa")

        AlertDialog.Builder(this)
            .setTitle("Filtrar por categoría")
            .setItems(categorias) { _, which ->
                val categoriaSeleccionada = categorias[which]
                val listaFiltrada = DataSet.getListaFiltrada(categoriaSeleccionada)
                adapterProducto.chageList(listaFiltrada)
                Snackbar.make(
                    binding.root,
                    "Mostrando: $categoriaSeleccionada",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}