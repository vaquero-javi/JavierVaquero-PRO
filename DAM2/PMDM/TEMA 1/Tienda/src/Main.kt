import model.Categoria
import model.CrearTienda
import model.Producto

fun main() {

    var camiseta: Producto = Producto(id = 1, precio = 14.99, categoria = Categoria.Ropa)
    var zapatillas: Producto = Producto(2, 20.0, categoria = Categoria.Ropa)
    //id, precio, nombre
    var pantalones = Producto(3, 30.0, nombre = "Pantalones", categoria = Categoria.Generica)
    //id, precio, descripcion
    var gorra = Producto(4, 5.0, descripcion = "Esto es una gorra")
    //todos
    var cinturon =
        Producto(5, 6.0, nombre = "Pantalones", descripcion = "Esto es un cinturon", categoria = Categoria.Tecnologia)

    //array
    val listaProductos: Array<Producto?> =
        arrayOf(camiseta, zapatillas, pantalones, gorra, cinturon)
    /*
        val listaProductoVacio:Array<Producto?> = arrayOfNulls(5)

        listaProductos.last()?.precio = 20.0
        listaProductos[2] = null

        for (i in listaProductos){
            i?.mostrarProductos()
        }

        listaProductos.forEach {
            it?.mostrarProductos()
        }

        listaProductos.forEachIndexed{index, producto ->
            println("Mostrando producto en posicion $index")
            producto?.mostrarProductos()
        }


        /*
        listaProductos[0].mostrarProductos()
        listaProductos.first() //es lo mismo esto y la linea anterior pero de distintas formas

        listaProductos[listaProductos.size-1].mostrarProductos()
        listaProductos.last()  //es lo mismo esto y la linea anterior pero de distintas formas
        */


     */

    camiseta.mostrarProductos()
    var tienda: CrearTienda = CrearTienda("Tienda de todo un poco")
    tienda.almacen = listaProductos
    tienda.buscarProductosCategotia(Categoria.Ropa)


    //Vamos a crear una tienda. Para ello crear la clase necesaria
    //donde se pueda asignar
    //1.Nombre de la tienda (obligatorio)
    //2.Almacen: sitio donde se guardan los productos
    //  Tiene un tamaño fijo de 6
    //3.Caja: se guardará la pasta cuando se venda un producto
}