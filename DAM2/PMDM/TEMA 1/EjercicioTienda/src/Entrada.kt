import controller.ControladorTienda
import model.*

fun main() {
    val tienda = Tienda("MiTienda")
    val controlador = ControladorTienda(tienda)

    while (true) {
        println(
            """
            |--- MENÚ TIENDA ---
            |1. Agregar producto al almacén
            |2. Mostrar productos del almacén
            |3. Vender producto por ID
            |4. Buscar producto por ID
            |5. Buscar productos por categoría
            |6. Registrar cliente
            |7. Mostrar clientes
            |8. Agregar producto al carrito de un cliente
            |9. Mostrar carrito de un cliente
            |10. Borrar producto del carrito
            |11. Pedir factura
            |12. Salir
        """.trimMargin()
        )

        print("Elige una opción: ")
        when (readln().toIntOrNull() ?: -1) {
            1 -> {
                print("ID del producto: "); val id = readln().toInt()
                print("Nombre del producto: "); val nombre = readln()
                print("Precio del producto: "); val precio = readln().toDouble()
                print("Categoria (Tecnologia, Muebles, Ropa, Generica): "); val cat = Categoria.valueOf(readln())
                val producto = Producto(id, precio, cat, nombre)
                controlador.agregarProducto(producto)
            }
            2 -> controlador.mostrarAlmacen()
            3 -> {
                print("ID del producto a vender: "); val id = readln().toInt()
                controlador.venderProducto(id)
            }
            4 -> {
                print("ID del producto a buscar: "); val id = readln().toInt()
                controlador.buscarProductoPorId(id)
            }
            5 -> {
                print("Categoria a buscar: "); val cat = Categoria.valueOf(readln())
                controlador.buscarProductosPorCategoria(cat)
            }
            6 -> {
                print("ID del cliente: "); val id = readln().toInt()
                print("Nombre del cliente: "); val nombre = readln()
                controlador.agregarCliente(Cliente(id, nombre))
            }
            7 -> controlador.listarClientes()
            8 -> {
                print("ID del cliente: "); val clienteId = readln().toInt()
                print("ID del producto a agregar: "); val id = readln().toInt()
                val producto = tienda.almacen.find { it?.id == id }
                if (producto != null) controlador.agregarProductoAlCarrito(clienteId, producto)
                else println("Producto no encontrado")
            }
            9 -> {
                print("ID del cliente: "); val clienteId = readln().toInt()
                controlador.mostrarCarrito(clienteId)
            }
            10 -> {
                print("ID del cliente: "); val clienteId = readln().toInt()
                print("ID del producto a borrar: "); val productoId = readln().toInt()
                controlador.borrarProductoCarrito(clienteId, productoId)
            }
            11 -> {
                print("ID del cliente: "); val clienteId = readln().toInt()
                controlador.pedirFactura(clienteId)
            }
            12 -> break // Salir del menú
            else -> println("Opción no válida")
        }
    }
}
