import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Header, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('MiAplicacion2.0');
  Username: string='Jose Antonio';
  number: number = 0;
  addOne(){
    this.number++
  }

  condicion: boolean=false;
  condicion2: string="Viva España"
}

