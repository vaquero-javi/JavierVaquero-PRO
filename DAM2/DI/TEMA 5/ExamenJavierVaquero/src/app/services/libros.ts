import { Injectable } from '@angular/core';
import { libro } from '../model/libro';

@Injectable({
  providedIn: 'root',
})
export class Libros {
  libros: libro[] = [];
  detalle?: libro;

  ejemplo?: libro;

  setLibros(data: libro[]) {
    this.libros = data;
  }

  setEjemplo(libro: libro) {
    this.ejemplo = libro;
  }

  getLibros(): libro[] {
    return this.libros;
  }

  getDetalle(): libro | undefined {
    return this.detalle;
  }

  limpiarDetalle() {
    this.detalle = undefined;
  }

  setDetalleById(id: number) {
    let encontrado = this.libros.find((item) => item.id == id);
    if (encontrado != undefined) {
      this.detalle = encontrado;
    } else {
      this.detalle = this.ejemplo;
    }
  }
}