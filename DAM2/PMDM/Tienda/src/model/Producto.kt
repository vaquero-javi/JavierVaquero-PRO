package model

class Producto(var id:Int, var precio: Double = 10.0, var nombre: String? = null, var descripcion: String? = null) {


    //CONSTRUCTORES SECUNDARIOS
    /*
    constructor(id: Int, precio: Double, nombre: String): this(id, precio){ // " : this(id,precio) " sirve para
        // retornarlo en el contructor secundario, siempre se hace asi
        this.nombre = nombre
    }

    constructor(id: Int, precio: Double, nombre: String, descripcion: String): this(id, precio){
        this.nombre = nombre
        this.descripcion = descripcion
    }
    */


    //Metodo para poder mostrar todos los datos del producto concreto
    //si no hay nombre, aparece "SIN NOMBRE"
    //si no hay descripcion, aparece "SIN DESCRIPCION"

    fun mostrarProductos(){
        println("ID: $id" )
        println("PRECIO: $precio")
        println("NOMBRE: ${nombre ?: "SIN DEFINIR"}")
        println("DESCRIPCION: ${descripcion ?: "SIN DEFINIR"}")
    }
}