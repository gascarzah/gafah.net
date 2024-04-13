import { TorreEdicionComponent } from './torre-edicion/torre-edicion.component';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

import { switchMap } from 'rxjs/operators';

import { MatSort } from '@angular/material/sort';
import { Torre } from '../../_model/torre';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { TorreService } from '../../_service/torre.service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-torre',
  templateUrl: './torre.component.html',
  styleUrls: ['./torre.component.css'],
})
export class TorreComponent implements OnInit {
  nombre: string;
  dias: number;
  precio: number;
  dataSource: MatTableDataSource<Torre>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  cantidad: number = 0;
  displayedColumns = ['nombre', 'dias', 'precio', 'acciones'];

  constructor(
    private torreService: TorreService,
    private snackBar: MatSnackBar,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.torreService.getTorreCambio().subscribe((data) => {
      this.crearTabla(data);
    });

    this.torreService.getMensajeCambio().subscribe((data) => {
      this.snackBar.open(data, 'AVISO', { duration: 2000 });
    });

    this.torreService.listarPageable(0, 5).subscribe((data) => {
      this.cantidad = data.totalElements;
      this.dataSource = new MatTableDataSource(data.content);
      this.dataSource.sort = this.sort;
    });
  }

  crearTabla(data: Torre[]) {
    this.dataSource = new MatTableDataSource(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  filtrar(valor: string) {
    this.dataSource.filter = valor.trim().toLowerCase();
  }

  mostrarMas(e: any) {
    this.torreService
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
        this.torreService
          .eliminar(id)
          .pipe(
            switchMap(() => {
              return this.torreService.listar();
            })
          )
          .subscribe((data) => {
            this.torreService.setTorreCambio(data);
            this.torreService.setMensajeCambio('SE ELIMINO');
          });
      }
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(TorreEdicionComponent, {
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
    const dialogRef = this.dialog.open(TorreEdicionComponent, {
      width: '500px',
      maxHeight: '600px',
      data: {
        idTorre: element.idTorre,
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
