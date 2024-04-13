import { VehiculoEdicionComponent } from './vehiculo-edicion/vehiculo-edicion.component';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { VehiculoService } from '../../_service/vehiculo.service';
import { Vehiculo } from '../../_model/vehiculo';

import { switchMap } from 'rxjs/operators';

import { MatSort } from '@angular/material/sort';

import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';

import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-vehiculo',
  templateUrl: './vehiculo.component.html',
  styleUrls: ['./vehiculo.component.css'],
})
export class VehiculoComponent implements OnInit {
  nombre: string;
  dias: number;
  precio: number;
  dataSource: MatTableDataSource<Vehiculo>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  cantidad: number = 0;
  displayedColumns = ['nombre', 'dias', 'precio', 'acciones'];

  constructor(
    private vehiculoService: VehiculoService,
    private snackBar: MatSnackBar,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.vehiculoService.getVehiculoCambio().subscribe((data) => {
      this.crearTabla(data);
    });

    this.vehiculoService.getMensajeCambio().subscribe((data) => {
      this.snackBar.open(data, 'AVISO', { duration: 2000 });
    });

    this.vehiculoService.listarPageable(0, 5).subscribe((data) => {
      this.cantidad = data.totalElements;
      this.dataSource = new MatTableDataSource(data.content);
      this.dataSource.sort = this.sort;
    });
  }

  crearTabla(data: Vehiculo[]) {
    this.dataSource = new MatTableDataSource(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  filtrar(valor: string) {
    this.dataSource.filter = valor.trim().toLowerCase();
  }

  mostrarMas(e: any) {
    this.vehiculoService
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
        this.vehiculoService
          .eliminar(id)
          .pipe(
            switchMap(() => {
              return this.vehiculoService.listar();
            })
          )
          .subscribe((data) => {
            this.vehiculoService.setVehiculoCambio(data);
            this.vehiculoService.setMensajeCambio('SE ELIMINO');
          });
      }
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(VehiculoEdicionComponent, {
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
    const dialogRef = this.dialog.open(VehiculoEdicionComponent, {
      width: '500px',
      maxHeight: '600px',
      data: {
        idVehiculo: element.idVehiculo,
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
