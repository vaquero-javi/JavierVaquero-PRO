import model.Producto

fun main() {

    var camiseta: Producto = Producto(id=1, precio = 14.99)
    var zapatillas : Producto = Producto(2,20.0)
    //id, precio, nombre
    var pantalones = Producto(3,30.0,"Pantalones")
    //id, precio, descripcion
    var gorra = Producto(4,5.0, descripcion = "Esto es una gorra")
    //todos
    var cinturon = Producto(5,6.0,"Pantalones", "Esto es un cinturon")

    //array
    val listaProductos: Array<Producto?> = arrayOf(camiseta, zapatillas, pantalones, gorra, cinturon)
    listaProductos.last()?.precio = 20.0
    listaProductos[2] = null

    for (i in listaProductos){
        i?.mostrarProductos()
    }


    /*
    listaProductos[0].mostrarProductos()
    listaProductos.first() //es lo mismo esto y la linea anterior pero de distintas formas

    listaProductos[listaProductos.size-1].mostrarProductos()
    listaProductos.last()  //es lo mismo esto y la linea anterior pero de distintas formas
    */




    camiseta.mostrarProductos()

}