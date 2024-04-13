import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from './home/home.component';
import { ArticuloVistaComponent } from './articulo/articulo-vista/articulo-vista.component';
import { ArticuloListComponent } from './articulo/articulo-list/articulo-list.component';
import { PromocionComponent } from './promocion/promocion.component';
import { AlumnoNuevoComponent } from './alumno/alumno-nuevo/alumno-nuevo.component';

/* import { LoginComponent } from './login/login.component';
import { AddUserComponent } from './user/add-user/add-user.component';
import { ListUserComponent } from './user/list-user/list-user.component';
import { EditUserComponent } from './user/edit-user/edit-user.component'; */


const routes: Routes = [
    { path: 'articulo-vista/:id', component: ArticuloVistaComponent },
    { path: 'articulo-lista/:id', component: ArticuloListComponent },
    {path : '', component : HomeComponent},
    { path: 'promocion', component: PromocionComponent },
    { path: 'alumno-nuevo', component: AlumnoNuevoComponent },
];

export const routing = RouterModule.forRoot(routes, {});