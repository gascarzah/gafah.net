import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { Persona } from '../_model/persona';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PersonaService extends GenericService<Persona> {
  private personaCambio = new Subject<Persona[]>();
  private mensajeCambio = new Subject<string>();

  constructor(protected http: HttpClient) {
    super(http, `${environment.HOST}/personas`);
  }

  listarPageable(p: number, s: number) {
    return this.http.get<any>(`${this.url}/pageable?page=${p}&size=${s}`);
  }

  // /* get, set */
  setMensajeCambio(mensaje: string) {
    this.mensajeCambio.next(mensaje);
  }

  getMensajeCambio() {
    return this.mensajeCambio.asObservable();
  }

  setPersonaCambio(lista: Persona[]) {
    this.personaCambio.next(lista);
  }

  getPersonaCambio() {
    return this.personaCambio.asObservable();
  }
}
