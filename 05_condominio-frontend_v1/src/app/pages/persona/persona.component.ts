import { PersonaEdicionComponent } from './persona-edicion/persona-edicion.component';

import { switchMap } from 'rxjs/operators';
import { PersonaService } from '../../_service/persona.service';
import { Persona } from '../../_model/persona';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css'],
})
export class PersonaComponent implements OnInit {
  displayedColumns = ['dni', 'nombres', 'telefono', 'celular'];
  dataSource: MatTableDataSource<Persona>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  cantidad: number = 0;
  dni: string;
  nombres: string;
  apellidoPaterno: string;
  apellidoMaterno: string;
  telefono: string;
  celular: string;

  constructor(
    private personaService: PersonaService,
    private snackBar: MatSnackBar,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.personaService.getPersonaCambio().subscribe((data) => {
      this.crearTabla(data);
    });

    this.personaService.getMensajeCambio().subscribe((data) => {
      this.snackBar.open(data, 'AVISO', { duration: 2000 });
    });

    this.personaService.listarPageable(0, 5).subscribe((data) => {
      this.cantidad = data.totalElements;
      this.dataSource = new MatTableDataSource(data.content);
      this.dataSource.sort = this.sort;
    });
  }

  filtrar(valor: string) {
    this.dataSource.filter = valor.trim().toLowerCase();
  }

  crearTabla(data: Persona[]) {
    this.dataSource = new MatTableDataSource(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
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
        this.personaService
          .eliminar(id)
          .pipe(
            switchMap(() => {
              return this.personaService.listar();
            })
          )
          .subscribe((data) => {
            this.personaService.setPersonaCambio(data);
            this.personaService.setMensajeCambio('SE ELIMINO');
          });
      }
    });
  }

  mostrarMas(e: any) {
    this.personaService
      .listarPageable(e.pageIndex, e.pageSize)
      .subscribe((data) => {
        this.cantidad = data.totalElements;
        this.dataSource = new MatTableDataSource(data.content);
        this.dataSource.sort = this.sort;
      });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(PersonaEdicionComponent, {
      width: '500px',
      // height: '600px',
      maxHeight: '600px',
      data: {
        nombres: this.nombres,
        apellidoPaterno: this.apellidoPaterno,
        apellidoMaterno: this.apellidoMaterno,
        telefono: this.telefono,
        //  email: this.email,
        //  direccion: this.direccion,
        //  activo: this.activo,
        //  imagen: this.imagen
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`The dialog was closed  ${result}`);
    });
  }

  openDialogMod(element: any): void {
    const dialogRef = this.dialog.open(PersonaEdicionComponent, {
      width: '500px',
      maxHeight: '600px',
      data: {
        idCliente: element.idCliente,
        dni: element.dni,
        nombres: element.nombres,
        apellidoPaterno: element.apellidoPaterno,
        apellidoMaterno: element.apellidoMaterno,
        telefono: element.telefono,
        email: element.email,
        direccion: element.direccion,
        activo: element.activo,
        imagen: element.imagen,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`The dialog was closed  ${result}`);
    });
  }
}
