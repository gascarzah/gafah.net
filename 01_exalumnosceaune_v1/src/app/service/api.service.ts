import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse } from '../model/api.response';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {
   }
   baseUrl: string = environment.backend.baseURL;

   getArticulo(articuloid: number) : Observable<ApiResponse>{
     return this.http.get<ApiResponse>(this.baseUrl + '/articulos/detalle/' + articuloid);
   }

   getArticulos() : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/articulos');
  }

  getTipoArticuloHome(tipartid: number) : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/tipoArticulos/home/'+ tipartid);
  } 

  
  getTipoArticuloList(tipartid: number) : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/tipoArticulos/list/'+ tipartid);
  } 

  getFotosArticulo(id: number) : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/articulos/fotos/'+ id);
  } 

  getRangos() : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/rangos/todo');
  }
  
  getDecadas(idrango: number) : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/promociones/decadas/'+idrango);
  } 

  getAnios(pdecada: number) : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/promociones/anios/'+pdecada);
  } 

  getSecciones(panio: number) : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/promociones/secciones/'+panio);
  } 

  getAlumnos(anio: number, seccion: string) : Observable<ApiResponse>{
    return this.http.get<ApiResponse>(this.baseUrl + '/personas/alumnos/'+anio+'/'+seccion);
  } 
}
