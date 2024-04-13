import { CocheraEdicionComponent } from './cochera-edicion/cochera-edicion.component';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { CocheraService } from '../../_service/cochera.service';

import { switchMap } from 'rxjs/operators';

import { MatSort } from '@angular/material/sort';

import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';

import { Component, OnInit, ViewChild } from '@angular/core';
import { Cochera } from 'src/app/_model/cochera';

@Component({
  selector: 'app-cochera',
  templateUrl: './cochera.component.html',
  styleUrls: ['./cochera.component.css'],
})
export class CocheraComponent implements OnInit {
  nombre: string;
  dias: number;
  precio: number;
  dataSource: MatTableDataSource<Cochera>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  cantidad: number = 0;
  displayedColumns = ['nombre', 'dias', 'precio', 'acciones'];

  constructor(
    private cocheraService: CocheraService,
    private snackBar: MatSnackBar,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.cocheraService.getCocheraCambio().subscribe((data) => {
      this.crearTabla(data);
    });

    this.cocheraService.getMensajeCambio().subscribe((data) => {
      this.snackBar.open(data, 'AVISO', { duration: 2000 });
    });

    this.cocheraService.listarPageable(0, 5).subscribe((data) => {
      this.cantidad = data.totalElements;
      this.dataSource = new MatTableDataSource(data.content);
      this.dataSource.sort = this.sort;
    });
  }

  crearTabla(data: Cochera[]) {
    this.dataSource = new MatTableDataSource(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  filtrar(valor: string) {
    this.dataSource.filter = valor.trim().toLowerCase();
  }

  mostrarMas(e: any) {
    this.cocheraService
      .listarPageable(e.pageIndex, e.pageSize)
      .subscribe((data) => {
        this.cantidad = data.totalElements;
        this.dataSource = new MatTableDataSource(data.content);
        this.dataSource.sort = this.sort;
      });
  }

  eliminar(id: number) {
    const confirmDialog = this.dialog.open(ConfirmDialogComponent, {
      data: {
        title: 'Confirmacion de eliminacion',
        message: 'Estas seguro de eliminar este elemento? ',
      },
    });

    confirmDialog.afterClosed().subscribe((result) => {
      if (result === true) {
        this.cocheraService
          .eliminar(id)
          .pipe(
            switchMap(() => {
              return this.cocheraService.listar();
            })
          )
          .subscribe((data) => {
            this.cocheraService.setCocheraCambio(data);
            this.cocheraService.setMensajeCambio('SE ELIMINO');
          });
      }
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CocheraEdicionComponent, {
      width: '500px',
      // height: '600px',
      maxHeight: '600px',
      data: {
        nombre: this.nombre,
        dias: this.dias,
        precio: this.precio,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`The dialog was closed  ${result}`);
    });
  }

  openDialogMod(element: any): void {
    const dialogRef = this.dialog.open(CocheraEdicionComponent, {
      width: '500px',
      maxHeight: '600px',
      data: {
        idCochera: element.idCochera,
        nombre: element.nombre,
        dias: element.dias,
        precio: element.precio,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`The dialog was closed  ${result}`);
    });
  }
}
