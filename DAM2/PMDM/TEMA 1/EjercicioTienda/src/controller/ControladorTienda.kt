package controller

import model.*

class ControladorTienda(val tienda: Tienda) {

    private val clientes = arrayListOf<Cliente>()

    fun agregarCliente(cliente: Cliente) {
        clientes.add(cliente)
        println("Cliente ${cliente.nombre} agregado correctamente")
    }

    fun listarClientes() {
        if (clientes.isEmpty()) {
            println("No hay clientes registrados")
        } else {
            clientes.forEach { println("ID: ${it.id}, Nombre: ${it.nombre}") }
        }
    }

    fun agregarProducto(producto: Producto) {
        tienda.agregarProducto(producto)
    }

    fun mostrarAlmacen() {
        tienda.mostrarAlmacen()
    }

    fun venderProducto(id: Int) {
        tienda.venderProducto(id)
    }

    fun buscarProductoPorId(id: Int) {
        val producto = tienda.buscarProductoId(id)
        if (producto == null) println("Producto no encontrado")
        else producto.mostrarDatos()
    }

    fun buscarProductosPorCategoria(categoria: Categoria) {
        tienda.buscarProductosCategoria(categoria)
    }

    fun agregarProductoAlCarrito(clienteId: Int, producto: Producto) {
        val cliente = clientes.find { it.id == clienteId }
        if (cliente != null) {
            cliente.agregarProductoCarrito(producto)
        } else println("Cliente no encontrado")
    }

    fun mostrarCarrito(clienteId: Int) {
        val cliente = clientes.find { it.id == clienteId }
        cliente?.mostrarCarrito() ?: println("Cliente no encontrado")
    }

    fun borrarProductoCarrito(clienteId: Int, productoId: Int) {
        val cliente = clientes.find { it.id == clienteId }
        cliente?.borrarElementos(productoId) ?: println("Cliente no encontrado")
    }

    fun pedirFactura(clienteId: Int) {
        val cliente = clientes.find { it.id == clienteId }
        cliente?.pedirFactura() ?: println("Cliente no encontrado")
    }
}
