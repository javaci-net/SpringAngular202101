import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoopsComponent } from './loops.component';

describe('LoopsComponent', () => {
  let component: LoopsComponent;
  let fixture: ComponentFixture<LoopsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoopsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoopsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
