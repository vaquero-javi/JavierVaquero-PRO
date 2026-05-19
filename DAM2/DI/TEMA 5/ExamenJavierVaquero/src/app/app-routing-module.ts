import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibrosComponent } from './components/libros/libros';
import { CarritoComponent } from './components/carrito/carrito';

const routes: Routes = [
  { path: 'libros', component: LibrosComponent },
  { path: 'carrito', component: CarritoComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'libros' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}