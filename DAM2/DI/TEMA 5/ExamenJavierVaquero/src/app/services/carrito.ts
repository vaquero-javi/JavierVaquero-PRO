import { Injectable } from '@angular/core';
import { libro } from '../model/libro';

@Injectable({
  providedIn: 'root',
})
export class Carrito {
  carrito: libro[] = [];

  agregarLibro(libro: libro) {
    this.carrito.push(libro);
  }

  getCarrito(): libro[] {
    return this.carrito;
  }
  
  vaciarCarrito() {
    this.carrito = [];
  }
}