package model

class CrearTienda(var nombreTienda: String = "Tienda de Javi") {
    var caja: Double = 0.0
    var almacen: Array<Producto?>

    //init -> ejecuta si o si despues del constructor (primario o secundario)
    init {
        almacen = arrayOfNulls(6)
    }

    //metodo para poder mostrar todos los productos del almacen.
    //En caso de tener todos los huecos disponibles (vacios) sacar un
    //aviso


    fun mostrarProductosAlmacen() {
        var contarnulos = 0
        almacen.forEach {
            it?.mostrarProductos() ?: contarnulos++ // ?: -> sirve para cuando sea nulo que sume al contador
            /*
            if (it==null ){
                contarnulos++
            }
             */
        }
        if (contarnulos == almacen.size){
            println("Aviso!!!No hay ningún valor predefinido")
        }
    }

    //Agregar un elemento al almacen, en caso de no tener hueco
    // disponible se mostrará un aviso

    fun agregarProducto(producto: Producto){
        for (item in 0.. almacen.size-1){
            if (almacen[item] == null){
                almacen[item] = producto
                return
            }
        }
        println("El almacen está completo")
    }

    //Vamos a vender un producto. Para ello se solicita el
    //id del producto a vender. En casode estar en el almacen:
        //Se elimina de este
        //Su precio es la suma a la caja
    //Si se vende se da aviso de producto vendido y se da el valor
    //de la caja, si no se encuentra se da aviso de que no esta en el
    //almacen

    fun venderProducto(producto: Producto){
        for (item in 0.. almacen.size-1){
            if (almacen[item]?.id == producto.id && almacen[item] != null){
                caja += almacen[item]!!.precio
                almacen[item] = null
                return
            }
        }
    }

    fun buscarProductosCategotia(categoria: Categoria){
        //filtrando -> obteniendo varios
        val filtro: List<Producto?> = almacen.filter {
            return@filter it?.categoria == categoria
        }

        println("El numero de elementos resultantes es ${filtro.size}")
    }

    fun buscarProductoId(id: Int){
        //buscando -> obtengo solo un elemento
        var productoBusqueda: Producto? = almacen.find {    //find -> te da un valor o nulo
            return@find it?.id == id
        }
    }
}
