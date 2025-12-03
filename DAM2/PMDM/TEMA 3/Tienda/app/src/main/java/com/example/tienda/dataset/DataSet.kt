package com.example.tienda.dataset

import com.example.tienda.model.Producto

class DataSet {
    companion object{
        var lista: ArrayList<Producto> = arrayListOf(
            Producto(1, "Pantalon", 12, 10.0,
                "pantalon", "ropa", "https://media.istockphoto.com/id/173239968/es/foto/fino-herm%C3%A9tico-jeans-azul-sobre-fondo-blanco.jpg?s=612x612&w=0&k=20&c=owv-YVYZRxIGPAvwkFWc3p5GgFgC8kAssFc1NeWxv0c="),
            Producto(2, "camiseta", 54, 10.0,
                "camiseta", "ropa", "https://media.istockphoto.com/id/483960103/es/foto/camiseta-negra-frontal-en-blanco-con-trazado-de-recorte.jpg?s=612x612&w=0&k=20&c=WTtkplvVBMxKTStHvG6rzKlw1G246bJ5apgJcNiFT_Q="),
            Producto(3, "maquillaje1", 78, 15.0,
                "maquillaje1", "belleza", "https://images.unsplash.com/photo-1596462502278-27bfdc403348?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bWFrZXVwfGVufDB8fDB8fHww"),
            Producto(4, "maquillaje2", 98, 12.0,
                "maquillaje2", "belleza", "https://resizer.sevilla.abc.es/resizer/resizer.php?imagen=https://sevilla.abc.es/estilo/bulevarsur/wp-content/uploads/sites/14/2016/08/diccionario-maquillaje-principiantes.jpg&nuevoancho=652"),
            Producto(5, "ordenador", 65, 19.0,
                "ordenador", "tecnologia", "https://www.objetivovalencia.es/wp-content/uploads/portatil-700x4671-1.jpg"),
            Producto(6, "mueble1", 32, 17.0,
                "mueble1", "mueble", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj_2pBP755FZqpeczng3PPkUkV5zsdCkW3dA&s"),
            Producto(7, "mueble2", 15, 18.0,
                "mueble2", "mueble", "https://www.stylohome.com/36404-large_default/mueble-de-salon-de-diseno.jpg")
        )

        var listaCarrito: ArrayList<Producto> = arrayListOf()

        fun addProducto (x: Producto){
            listaCarrito.add(x)
        }

        fun getListaFiltrada(categoria: String): List<Producto> {
            return lista.filter { it.categoria.equals(categoria, true) }
        }
    }
}