import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ApiService } from '../service/api.service';
import { Articulo } from '../model/articulo.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private _Activatedroute:ActivatedRoute, private router: Router, private apiService: ApiService) { }
  eventos: Articulo[];
  curiosidades: Articulo[];
  oro: number;
  plata: number;
  rubi: number;
  perla: number;
  anioActual: number;
  zafiro: number;
  ngOnInit() {
  this.anioActual = (new Date()).getFullYear();
  
  this.oro = this.anioActual - 50;
  this.zafiro = this.anioActual - 45;
  this.plata = this.anioActual - 25;
  this.rubi = this.anioActual - 40;
  this.perla = this.anioActual - 30;
  this.anioActual = this.anioActual - 25;
  

  /* console.log(this.anioActual + " "+ this.zafiro) */
    this.apiService.getTipoArticuloHome(2).subscribe( data => {
      this.eventos = data.result;
      console.log(this.eventos)
       });

       this.apiService.getTipoArticuloHome(3).subscribe( data => {
        this.curiosidades = data.result;
        
         });
  }

}
