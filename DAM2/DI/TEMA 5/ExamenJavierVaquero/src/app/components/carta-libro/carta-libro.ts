import { Component, Input } from '@angular/core';
import { libro } from '../../model/libro';
import { Libros } from '../../services/libros';
import { Carrito } from '../../services/carrito';

@Component({
  selector: 'app-carta-libro',
  standalone: false,
  templateUrl: './carta-libro.html',
  styleUrl: './carta-libro.css',
})
export class CartaLibro {
  @Input() item?: libro;

  constructor(
    private servicioLibros: Libros,
    private servicioCarrito: Carrito,
  ) {}

  verDetalle(id: number) {
    // detalle NO navegable (se muestra dentro de Libros)
    this.servicioLibros.setDetalleById(id);
  }

  agregarCarrito() {
    if (this.item != undefined) {
      this.servicioCarrito.agregarLibro(this.item);
    } else {
      // saltar un aviso
    }
  }
}