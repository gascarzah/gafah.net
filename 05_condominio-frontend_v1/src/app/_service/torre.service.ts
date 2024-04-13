import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { Torre } from '../_model/torre';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TorreService extends GenericService<Torre>{

  private torreCambio = new Subject<Torre[]>();
  private mensajeCambio = new Subject<string>();

  constructor(protected http: HttpClient) {
    super(
      http,
      `${environment.HOST}/torres`);
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

  setTorreCambio(lista: Torre[]){
    this.torreCambio.next(lista);
  }

  getTorreCambio(){
    return this.torreCambio.asObservable();
  }


}
