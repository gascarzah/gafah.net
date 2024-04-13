import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { TipoPersona } from '../_model/tipo-persona';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TipoPersonaService extends GenericService<TipoPersona>{

  private tipopersonaCambio = new Subject<TipoPersona[]>();
  private mensajeCambio = new Subject<string>();

  constructor(protected http: HttpClient) {
    super(
      http,
      `${environment.HOST}/tipopersonas`);
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

  setTipoPersonaCambio(lista: TipoPersona[]){
    this.tipopersonaCambio.next(lista);
  }

  getTipoPersonaCambio(){
    return this.tipopersonaCambio.asObservable();
  }


}
