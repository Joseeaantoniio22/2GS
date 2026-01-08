import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuariosService } from './app.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h1>Usuarios</h1>
    <ul>
      <li *ngFor="let usuario of usuarios">
        {{ usuario.id }} - {{ usuario.nombre }} ({{ usuario.edad }} años)
      </li>
    </ul>

    <h2>Agregar Usuario</h2>
    <input name="nombre" [(ngModel)]="nuevoNombre" placeholder="Nombre" />
    <input name="edad" type="number" [(ngModel)]="nuevaEdad" placeholder="Edad" />
    <button (click)="agregarUsuario()">Agregar</button>
  `,
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  usuarios: any[] = [];
  nuevoNombre = '';
  nuevaEdad: number | null = null;

  constructor(private usuariosService: UsuariosService) {}

  ngOnInit(): void {
    this.cargarUsuarios();
  }

  cargarUsuarios(): void {
    this.usuariosService
      .getUsuarios()
      .subscribe(data => this.usuarios = data);
  }

  agregarUsuario(): void {
    if (this.nuevoNombre && this.nuevaEdad !== null) {
      const usuario = { nombre: this.nuevoNombre, edad: this.nuevaEdad };
      this.usuariosService
        .agregarUsuario(usuario)
        .subscribe(() => this.cargarUsuarios());

      this.nuevoNombre = '';
      this.nuevaEdad = null;
    }
  }
}
