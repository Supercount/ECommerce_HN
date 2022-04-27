import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnsemblesComponent } from './ensembles.component';

describe('EnsemblesComponent', () => {
  let component: EnsemblesComponent;
  let fixture: ComponentFixture<EnsemblesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnsemblesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnsemblesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
