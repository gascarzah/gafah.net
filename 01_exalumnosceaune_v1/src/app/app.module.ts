import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { routing } from "./app.routing";
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { PromocionComponent } from './promocion/promocion.component';
import { ArticuloVistaComponent } from './articulo/articulo-vista/articulo-vista.component';
import { ArticuloListComponent } from './articulo/articulo-list/articulo-list.component';

import localeEsPe from '@angular/common/locales/es-PE';
import { HashLocationStrategy, LocationStrategy, registerLocaleData } from '@angular/common';
import { AlumnoNuevoComponent } from './alumno/alumno-nuevo/alumno-nuevo.component';

registerLocaleData(localeEsPe, 'es-Pe');

@NgModule({
  declarations: [

    AppComponent,
    HomeComponent,
    ArticuloVistaComponent,
    ArticuloListComponent,
    PromocionComponent,
    AlumnoNuevoComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [{provide: LOCALE_ID, useValue: 'es_PE'},
  {provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
