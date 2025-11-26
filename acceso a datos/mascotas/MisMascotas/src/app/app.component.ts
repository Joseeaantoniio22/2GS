import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PetTrackerComponent } from "./pet-tracker/pet-tracker.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, PetTrackerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'MisMascotas';
  
}
