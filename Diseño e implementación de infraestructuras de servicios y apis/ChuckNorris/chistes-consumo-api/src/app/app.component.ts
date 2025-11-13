import { Component } from '@angular/core';
import { ChistesService } from './chistes.service';

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  constructor(private chistesService: ChistesService){}
  chiste = "";

  cargaChiste(){
    this.chiste = 'Cargando chiste...';
    this.chistesService.getChiste().subscribe(
      nuevoChiste => this.chiste = nuevoChiste
    )
  }
}




