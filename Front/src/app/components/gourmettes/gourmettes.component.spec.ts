import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GourmettesComponent } from './gourmettes.component';

describe('GourmettesComponent', () => {
  let component: GourmettesComponent;
  let fixture: ComponentFixture<GourmettesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GourmettesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GourmettesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
