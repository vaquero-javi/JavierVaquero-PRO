package com.example.examenjaviervaquero.databases;

public interface SchemeDB {
    String URL = "127.0.0.1";
    String PORT = "3306";
    String DB_NAME = "tienda_online";
    String TAB_NAME = "usuarios";
    String COL_ID = "id";
    String COL_NAME = "nombre";
    String COL_MAIL = "mail";
    String COL_PASS="contraseña";

    String TAB_NAME="productos";
    String COL_PROD_ID="id";
    String COL_PROD_NOMBRE="nombre";
    String COL_CAT="categoria";
    String COL_PRECIO="precio";
}
