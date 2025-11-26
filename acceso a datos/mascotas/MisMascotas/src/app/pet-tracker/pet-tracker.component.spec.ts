import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetTrackerComponent } from './pet-tracker.component';

describe('PetTrackerComponent', () => {
  let component: PetTrackerComponent;
  let fixture: ComponentFixture<PetTrackerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PetTrackerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PetTrackerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
