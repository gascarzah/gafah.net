import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { Departamento } from '../_model/departamento';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService extends GenericService<Departamento>{

  private departamentoCambio = new Subject<Departamento[]>();
  private mensajeCambio = new Subject<string>();

  constructor(protected http: HttpClient) {
    super(
      http,
      `${environment.HOST}/departamentos`);
  }

  listarPageable(p: number, s:number){
    return this.http.get<any>(`${this.url}/pageable?page=${p}&size=${s}`);
  }

  // /* get, set */
  setMensajeCambio(mensaje: string){
    this.mensajeCambio.next(mensaje);
  }

  getMensajeCambio(){
    return this.mensajeCambio.asObservable();
  }

  setDepartamentoCambio(lista: Departamento[]){
    this.departamentoCambio.next(lista);
  }

  getDepartamentoCambio(){
    return this.departamentoCambio.asObservable();
  }


}
