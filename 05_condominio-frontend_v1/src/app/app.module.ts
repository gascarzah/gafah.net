
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PersonaComponent } from './pages/persona/persona.component';
import { MaterialModule } from './material/material.module';
import { ConfirmDialogComponent } from './pages/confirm-dialog/confirm-dialog.component';
import { HttpClientModule } from '@angular/common/http';
import { PersonaEdicionComponent } from './pages/persona/persona-edicion/persona-edicion.component';
import { CocheraComponent } from './pages/cochera/cochera.component';
import { DepartamentoComponent } from './pages/departamento/departamento.component';
import { TorreComponent } from './pages/torre/torre.component';
import { VehiculoComponent } from './pages/vehiculo/vehiculo.component';
import { VehiculoEdicionComponent } from './pages/vehiculo/vehiculo-edicion/vehiculo-edicion.component';
import { TorreEdicionComponent } from './pages/torre/torre-edicion/torre-edicion.component';
import { DepartamentoEdicionComponent } from './pages/departamento/departamento-edicion/departamento-edicion.component';
import { CocheraEdicionComponent } from './pages/cochera/cochera-edicion/cochera-edicion.component';
@NgModule({
  declarations: [
    AppComponent,
    PersonaComponent,
    ConfirmDialogComponent,
    PersonaEdicionComponent,
    CocheraComponent,
    DepartamentoComponent,
    TorreComponent,
    VehiculoComponent,
    VehiculoEdicionComponent,
    TorreEdicionComponent,
    DepartamentoEdicionComponent,
    CocheraEdicionComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
