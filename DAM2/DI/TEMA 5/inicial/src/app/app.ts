import { Component, signal } from '@angular/core';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('inicial');
  nombre = 'Javier';
  apellidos = 'Vaquero';
  curso = 2;
  nombreCurso = "Desarrollo de Aplicaciones Multiplataforma";
  nota: number|string = 0;

  pulsarComenzar(notaInput: string){
    if(isNaN(Number(notaInput))){

    }else{
      Swal.fire({
      title: 'Error!',
      text: 'Do you want to continue',
      icon: 'error',
      confirmButtonText: 'Cool'
      })
    }

    this.nota = Number(notaInput);
  }
}
