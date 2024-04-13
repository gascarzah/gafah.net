import { Component, OnInit } from '@angular/core';
import { Promocion } from '../model/promocion.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../service/api.service';
import { Rango } from '../model/rango.model';
import { Decada } from '../model/decada.model';
import { Persona } from '../model/persona.model';

@Component({
  selector: 'app-promocion',
  templateUrl: './promocion.component.html',
  styleUrls: ['./promocion.component.css']
})
export class PromocionComponent implements OnInit {

  constructor(private _Activatedroute:ActivatedRoute, private router: Router, private apiService: ApiService) { }
  rangos: Rango[];
  rango: Rango;
  decadas: Decada[];
  decada: Decada;
  anios: Decada[];
  secciones: Decada[];
  selectRango: number;
  selectAnio: number=0;
  selectDecada: number;
  selectSeccion: string;
  alumnos: Persona[];

  ngOnInit() {
    this._Activatedroute.paramMap.subscribe(params => {
      
    
      this.apiService.getRangos().subscribe( 
        data => { this.rangos = data.result; 
        },
        error => console.log('oops', error)
       );
  
       
   
    });
  }

/*   cambiarDecadas(idrango: number) {
    this.anios=[];
    this.secciones=[];
    this.alumnos = [];
		this.apiService.getAnios(idrango).subscribe( 
      
      data => { 
        
        this.anios = data.result; 
       
      },
      error => console.log('oops', error)
     );
	} */

  cambiarAnios(pdecada: number) {
    this.selectAnio = 0;
    this.secciones=[];
    this.alumnos = [];
    
		this.apiService.getAnios(pdecada).subscribe( 
      
      data => { 
        
        this.anios = data.result; 
        
      },
      error => console.log('oops', error)
     );
  }
  
  cambiarSecciones(panio: number) {
 
    this.alumnos = [];
    
		this.apiService.getSecciones(panio).subscribe( 
      
      data => { 
        
        this.secciones = data.result; 
        
      },
      error => console.log('oops', error)
     );
  }
  
  obtenerPromocion(seccion: string){

    
    this.apiService.getAlumnos(this.selectAnio,seccion).subscribe( 
      
      data => { 
        
        this.alumnos = data.result; 
        
      },
      error => console.log('oops', error)
     );
  }
}
