import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

type PetType = 'Perro' | 'Gato' | 'Otro';

interface Pet {
  name: string;
  fed: boolean;
  type: PetType;
}


@Component({
  selector: 'app-pet-tracker',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './pet-tracker.component.html',
  styleUrl: './pet-tracker.component.css'
})

export class PetTrackerComponent {
  pets: Pet[] = [];
  ordenarAlfabetico: boolean = false; 
  newPet: string = '';
  newPetType: PetType = 'Perro'; 
  filter: string = "all";

  addPet() {
    const name = this.newPet.trim();

    if (!name) return;

    if (name.length < 3) {
      alert("El nombre debe tener al menos 3 letras");
      return;
    }


    const exists = this.pets.some(
      pet => pet.name.toLowerCase() === name.toLowerCase()
    );

    if (exists) {
      alert(`La mascota "${name}" ya existe`);
      return;
    }

    this.pets.push({ 
      name, 
      fed: false, 
      type: this.newPetType
    });
    
    this.newPet = '';
    this.newPetType = 'Perro';
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
    let listaFiltrada = [...this.pets];

    switch (this.filter) {
      case 'Alimentada':
        listaFiltrada = listaFiltrada.filter(p => p.fed);
        break;
      case 'Hambrienta':
        listaFiltrada = listaFiltrada.filter(p => !p.fed);
        break;
    }

    if (this.ordenarAlfabetico) {
      listaFiltrada.sort((a, b) => a.name.localeCompare(b.name));
    }

    return listaFiltrada;

  }

  // 5. Un pequeño ayudante para mostrar iconos según el tipo (Opcional pero visual)
  getIcon(type: PetType): string {
    switch (type) {
      case 'Perro': return '🐶';
      case 'Gato': return '🐱';
      default: return '🐾';
    }
  }
}