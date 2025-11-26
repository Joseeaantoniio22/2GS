import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Pet {
  name: string;
  fed: boolean;
}

@Component({
  selector: 'app-pet-tracker',
  imports: [FormsModule, CommonModule],
  templateUrl: './pet-tracker.component.html',
  styleUrl: './pet-tracker.component.css'
})

export class PetTrackerComponent {
  pets: Pet[] = [
  ]

  newPet: string= '';
  filter: string="all";

  addPet() {
    const name = this.newPet.trim();

    if (!name) return;

    const exists = this.pets.some(
      pet => pet.name.toLowerCase() === name.toLowerCase()
    );

    if (exists) {
      alert(`La mascota "${name}" ya existe`);
      return;
    }

    this.pets.push({ name, fed: false });
    this.newPet = '';
  }

  toggleFed(pet: Pet){
    pet.fed = !pet.fed;
  }

  deletePet(nombre: string){
    this.pets = this.pets.filter(pet => pet.name !== nombre);
  }

  get fedCount(): number {
    return this.pets.filter(p => p.fed).length;
  }

  get filteredPets(): Pet[] {
    switch (this.filter) {
      case 'Alimentada':
        return this.pets.filter(p => p.fed);
      case 'Hambrienta':
        return this.pets.filter(p => !p.fed);
      default:
        return this.pets;
    }
  }
}
