package com.example.practicaevaluacion.database;

public interface SchemeDB {  // CON "public"
    String URL = "127.0.0.1";
    String PORT = "3306";
    String DB_NAME = "tienda";

    String TAB_USUARIOS = "usuarios";
    String COL_USUARIO_ID = "usuario_id";
    String COL_USUARIO_NOMBRE = "usuario_nombre";
    String COL_USUARIO_EMAIL = "usuario_email";
    String COL_USUARIO_PASSWORD = "usuario_password";

    String TAB_PRODUCTOS = "productos";
    String COL_PRODUCTO_ID = "productos_id";
    String COL_PRODUCTO_NOMBRE = "productos_nombre";
    String COL_PRODUCTO_DESCRIPCION = "productos_descripcion";
    String COL_PRODUCTO_PRECIO = "productos_precio";
    String COL_PRODUCTO_STOCK = "productos_stock";

    String TAB_COMPRAS = "compras";
    String COL_COMPRA_ID = "compra_id";
    String COL_COMPRA_USUARIO_ID = "compra_usuario_id";
    String COL_COMPRA_PRODUCTO_ID = "compra_productos_id";
    String COL_COMPRA_CANTIDAD = "compra_cantidad";
    String COL_COMPRA_FECHA = "compra_fecha";
}