import { Component } from '@angular/core';
import { libro } from '../../model/libro';
import { Carrito } from '../../services/carrito';



declare const Swal: any;

@Component({
  selector: 'app-carrito',
  standalone: false,
  templateUrl: './carrito.html',
  styleUrl: './carrito.css',
})
export class CarritoComponent {
  libros: libro[] = [];

  constructor(private servicioCarrito: Carrito) {
    this.libros = this.servicioCarrito.getCarrito();
  }

  comprar() {
    if (typeof window !== 'undefined' && (window as any).Swal) {
      Swal.fire({
        title: 'Compra correcta',
        icon: 'success',
      });
    } else {
      alert('Compra correcta');
    }

    this.servicioCarrito.vaciarCarrito();
    this.libros = this.servicioCarrito.getCarrito();
  }
}