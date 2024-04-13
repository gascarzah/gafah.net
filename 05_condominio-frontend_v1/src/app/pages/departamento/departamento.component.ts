import { DepartamentoEdicionComponent } from './departamento-edicion/departamento-edicion.component';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

import { switchMap } from 'rxjs/operators';

import { MatSort } from '@angular/material/sort';
import { Departamento } from '../../_model/departamento';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { DepartamentoService } from '../../_service/departamento.service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-departamento',
  templateUrl: './departamento.component.html',
  styleUrls: ['./departamento.component.css'],
})
export class DepartamentoComponent implements OnInit {
  nombre: string;
  dias: number;
  precio: number;
  dataSource: MatTableDataSource<Departamento>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  cantidad: number = 0;
  displayedColumns = ['nombre', 'dias', 'precio', 'acciones'];

  constructor(
    private departamentoService: DepartamentoService,
    private snackBar: MatSnackBar,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.departamentoService.getDepartamentoCambio().subscribe((data) => {
      this.crearTabla(data);
    });

    this.departamentoService.getMensajeCambio().subscribe((data) => {
      this.snackBar.open(data, 'AVISO', { duration: 2000 });
    });

    this.departamentoService.listarPageable(0, 5).subscribe((data) => {
      this.cantidad = data.totalElements;
      this.dataSource = new MatTableDataSource(data.content);
      this.dataSource.sort = this.sort;
    });
  }

  crearTabla(data: Departamento[]) {
    this.dataSource = new MatTableDataSource(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  filtrar(valor: string) {
    this.dataSource.filter = valor.trim().toLowerCase();
  }

  mostrarMas(e: any) {
    this.departamentoService
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
        this.departamentoService
          .eliminar(id)
          .pipe(
            switchMap(() => {
              return this.departamentoService.listar();
            })
          )
          .subscribe((data) => {
            this.departamentoService.setDepartamentoCambio(data);
            this.departamentoService.setMensajeCambio('SE ELIMINO');
          });
      }
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(DepartamentoEdicionComponent, {
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
    const dialogRef = this.dialog.open(DepartamentoEdicionComponent, {
      width: '500px',
      maxHeight: '600px',
      data: {
        idDepartamento: element.idDepartamento,
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
