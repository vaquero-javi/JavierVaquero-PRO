import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';

import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';

import { PortadasPipe } from './pipes/portadas-pipe';

import { LibrosComponent } from './components/libros/libros';
import { CarritoComponent } from './components/carrito/carrito';
import { CartaLibro } from './components/carta-libro/carta-libro';
import { Detalles } from './components/detalles/detalles';

@NgModule({
  declarations: [App, LibrosComponent, CarritoComponent, CartaLibro, Detalles, PortadasPipe],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [App],
})
export class AppModule {}