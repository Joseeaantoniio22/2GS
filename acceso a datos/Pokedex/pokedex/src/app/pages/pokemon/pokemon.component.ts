import { TitleCasePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DigitNumberPipe } from '../../pipes/digit-number.pipe';
import { PokemonTypeComponent } from '../../components/pokemon-type/pokemon-type.component';
import { PokemonDetail } from '../../models/pokemon-detail';
import { PokeapiService } from '../../services/pokeapi.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pokemon',
  standalone: true,
  imports: [DigitNumberPipe, TitleCasePipe, PokemonTypeComponent],
  templateUrl: './pokemon.component.html',
  styleUrl: './pokemon.component.css'
 })
 export class PokemonComponent implements OnInit {
  pokemon: PokemonDetail | null = null;
  constructor(
  private pokeapi: PokeapiService,
  private activatedRoute: ActivatedRoute) { }
  async ngOnInit(): Promise<void> {
  const id = this.activatedRoute.snapshot.paramMap.get('id') as unknown as
 number;
  this.pokemon = await this.pokeapi.getPokemonDetail(id);
  }
 }
