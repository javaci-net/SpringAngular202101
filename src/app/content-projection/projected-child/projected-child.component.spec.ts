import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectedChildComponent } from './projected-child.component';

describe('ProjectedChildComponent', () => {
  let component: ProjectedChildComponent;
  let fixture: ComponentFixture<ProjectedChildComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectedChildComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectedChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
