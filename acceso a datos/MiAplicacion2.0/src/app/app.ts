import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
<<<<<<< HEAD
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, Header, FormsModule],
=======

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header],
>>>>>>> 5287271cae2a8e77ad7d134aec07d80829d28345
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('MiAplicacion2.0');
  Username: string='Jose Antonio';
<<<<<<< HEAD
  number: number = 0;
  addOne(){
    this.number++
  }
}

=======
}
>>>>>>> 5287271cae2a8e77ad7d134aec07d80829d28345
