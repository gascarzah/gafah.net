import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Articulo } from 'src/app/model/articulo.model';
import { PagerService } from 'src/app/service/pager.service';

@Component({
  selector: 'app-articulo-list',
  templateUrl: './articulo-list.component.html',
  styleUrls: ['./articulo-list.component.css']
})
export class ArticuloListComponent implements OnInit {

    // Paginación
    pager: any = {};
    pagedItems: any[];

  constructor(private _Activatedroute:ActivatedRoute, private router: Router, private apiService: ApiService,
    private pagerService: PagerService) { }
  id: number;
  articulo: Articulo;
  articulos: Articulo[];
  ngOnInit() {

    this._Activatedroute.paramMap
    .subscribe(params => {
      /* console.log(params); */
      this.id = +params.get('id');
  
  this.apiService.getTipoArticuloList(this.id).subscribe( data => {
    /* console.log(data) */
    this.articulos = data.result;
    this.setPage(1);

     });
  });
  }


  setPage(page: number) {
    this.pager = this.pagerService.getPager(this.articulos.length, page);
    this.pagedItems = this.articulos.slice(this.pager.startIndex, this.pager.endIndex + 1);
  }

}
