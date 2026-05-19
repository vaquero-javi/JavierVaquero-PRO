import { Component, Input } from '@angular/core';
import { libro } from '../../../app/model/libro';
import { Libros } from '../../../app/services/libros';

@Component({
  selector: 'app-detalles',
  standalone: false,
  templateUrl: './detalles.html',
  styleUrl: './detalles.css',
})
export class Detalles {
  @Input() libro?: libro;

  constructor(private servicioLibros: Libros) {}

  cerrar() {
    this.servicioLibros.limpiarDetalle();
  }
}