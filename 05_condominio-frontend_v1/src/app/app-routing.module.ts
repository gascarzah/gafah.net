import { VehiculoComponent } from './pages/vehiculo/vehiculo.component';
import { TorreComponent } from './pages/torre/torre.component';
import { CocheraComponent } from './pages/cochera/cochera.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonaComponent } from './pages/persona/persona.component';

const routes: Routes = [
  {path: 'persona', component: PersonaComponent},
  {path: 'cochera', component: CocheraComponent},
  {path: 'torre', component: TorreComponent},
  {path: 'vehiculo', component: VehiculoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
