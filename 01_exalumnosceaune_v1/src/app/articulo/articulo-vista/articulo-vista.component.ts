import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';
import { ActivatedRoute } from '@angular/router';
import { Articulo } from 'src/app/model/articulo.model';
import { UntypedFormGroup } from '@angular/forms';
import { Foto } from 'src/app/model/foto.model';

@Component({
  selector: 'app-articulo-vista',
  templateUrl: './articulo-vista.component.html',
  styleUrls: ['./articulo-vista.component.css']
})
export class ArticuloVistaComponent implements OnInit {

  constructor(private _Activatedroute:ActivatedRoute, private router: Router, private apiService: ApiService) { }
  id: number;
  articulo: Articulo;
  articuloDetForm: UntypedFormGroup;
  fotos: Foto[];

  ngOnInit() {

    this._Activatedroute.paramMap.subscribe(params => {
    this.id = +params.get('id');

    this.apiService.getArticulo(this.id).subscribe(
      data => { this.articulo = data.result;
        //  console.log(this.articulo)
       },
      error => console.log('oops', error)
     );

     this.apiService.getFotosArticulo(this.id).subscribe(data => {
      this.fotos = data.result;
      //  console.log("fotos")
      // console.log(this.fotos)
    })

  });

  }



}

