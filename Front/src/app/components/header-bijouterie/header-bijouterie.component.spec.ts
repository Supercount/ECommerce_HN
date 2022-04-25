import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderBijouterieComponent } from './header-bijouterie.component';

describe('HeaderBijouterieComponent', () => {
  let component: HeaderBijouterieComponent;
  let fixture: ComponentFixture<HeaderBijouterieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderBijouterieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderBijouterieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
