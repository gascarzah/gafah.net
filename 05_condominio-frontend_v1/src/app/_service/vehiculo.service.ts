import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { Vehiculo } from '../_model/vehiculo';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VehiculoService extends GenericService<Vehiculo>{

  private vehiculoCambio = new Subject<Vehiculo[]>();
  private mensajeCambio = new Subject<string>();

  constructor(protected http: HttpClient) {
    super(
      http,
      `${environment.HOST}/vehiculos`);
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

  setVehiculoCambio(lista: Vehiculo[]){
    this.vehiculoCambio.next(lista);
  }

  getVehiculoCambio(){
    return this.vehiculoCambio.asObservable();
  }


}
