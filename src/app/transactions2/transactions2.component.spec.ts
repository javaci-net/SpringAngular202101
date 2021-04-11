import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Transactions2Component } from './transactions2.component';

describe('Transactions2Component', () => {
  let component: Transactions2Component;
  let fixture: ComponentFixture<Transactions2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Transactions2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Transactions2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
