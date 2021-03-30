import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompenentInteractionComponent } from './compenent-interaction.component';

describe('CompenentInteractionComponent', () => {
  let component: CompenentInteractionComponent;
  let fixture: ComponentFixture<CompenentInteractionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompenentInteractionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompenentInteractionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
