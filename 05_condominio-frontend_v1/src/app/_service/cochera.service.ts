import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { Cochera } from '../_model/cochera';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CocheraService extends GenericService<Cochera>{

  private cocheraCambio = new Subject<Cochera[]>();
  private mensajeCambio = new Subject<string>();

  constructor(protected http: HttpClient) {
    super(
      http,
      `${environment.HOST}/cocheras`);
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

  setCocheraCambio(lista: Cochera[]){
    this.cocheraCambio.next(lista);
  }

  getCocheraCambio(){
    return this.cocheraCambio.asObservable();
  }


}
