import { Component } from '@angular/core';
import { libro } from '../../model/libro';
import { Datos } from '../../services/datos';
import { Libros } from '../../services/libros';


@Component({
  selector: 'app-libros',
  standalone: false,
  templateUrl: './libros.html',
  styleUrl: './libros.css',
})
export class LibrosComponent {
  libros: libro[] = [];

  constructor(
    private datosService: Datos,
    private servicioLibros: Libros,
  ) {
   
    this.datosService.getLibrosTxt().subscribe({
      next: (txt) => {
        let data = this.datosService.parseLibros(txt);
        this.servicioLibros.setLibros(data);
        this.libros = this.servicioLibros.getLibros();
      },
      error: (err) => {
      
      },
    });

    
    this.datosService.getLibroTxt().subscribe({
      next: (txt) => {
        let data = this.datosService.parseLibro(txt);
        this.servicioLibros.setEjemplo(data);
      },
      error: (err) => {
      },
    });
  }

  get detalle() {
    return this.servicioLibros.getDetalle();
  }
}
