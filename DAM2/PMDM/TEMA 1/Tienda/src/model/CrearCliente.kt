package model

class CrearCliente(var id: Int, var nombre: String) {
    lateinit var carrito: ArrayList<Producto>
    var factura: Double = 0.0

    init {
        carrito = arrayListOf()
    }

    fun agregarProductoCarrito(producto: Producto) {

        carrito.add(producto)
        println("Producto agregado al carrito correctamente")

    }

    //mostrar todos los elementos del carrito
    fun mostrarCarrito() {
        if (carrito.isEmpty()) {
            println("No hay nada en el carrito")
        } else {
            carrito.forEach { it.mostrarProductos() }
        }
    }

    //mostrar el producto en una posicion indicada
    fun accesoPorPosicion(posicion: Int) {
        if (posicion > carrito.size - 1) {
            println("Posicion fuera de rango")
        } else {
            carrito[posicion].mostrarProductos()
        }
    }

    //eliminar un producto del carrito
        //en caso de no estar id en el carrito -> no se encuentra
        //en caso de estar id y solo existir 1 -> lo elimina
        //en casi de estar id y existir +1 -> confirmación de eliminar 1 o todos
    fun filtrarCarrito() {
        carrito.filter {
            return@filter true
        }
    }
    fun eliminarElementos(id: Int){
        var listaFiltrada = carrito.filter {
            return@filter it.id == id
        }

        if (listaFiltrada.isEmpty()){
            println("No hay nada, no se pueded borrar")
        }else if (listaFiltrada.size == 1){
            carrito.remove(listaFiltrada.first())
            println("Borrado correctamente")
        }else{
            println("Se han encontrado varias coincidencias cual quieres borrar" +
                    "(1. para primero / n para todos")
            val opcion: String = readln()
            if (opcion.equals("1", true)){
                carrito.remove(listaFiltrada.first())
            }else if (opcion.equals("n", true)){
                carrito.removeAll(listaFiltrada.toSet()) //pasa la lista a un tipo de lista fija, simplemente es por rendimiento
            }
        }
        println("el numero  de resulrado es ${listaFiltrada.size}")
    }

    fun pedirFactura(){
        if (carrito.isEmpty()){
            println("No hay productos en carrito")
        }else{
            carrito.forEach{
                factura+=it.precio
            }
            println("Debes un total de $factura")
            carrito.clear()
        }
    }
}