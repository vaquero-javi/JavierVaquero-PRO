import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { libro } from '../model/libro';

@Injectable({
  providedIn: 'root',
})
export class Datos {
  constructor(private http: HttpClient) {}

  getLibrosTxt() {
    return this.http.get('assets/libros.txt', { responseType: 'text' });
  }

  getLibroTxt() {
    return this.http.get('assets/libro.txt', { responseType: 'text' });
  }

  parseLibros(txt: string): libro[] {
    return JSON.parse(txt) as libro[];
  }

  parseLibro(txt: string): libro {
    return JSON.parse(txt) as libro;
  }
}