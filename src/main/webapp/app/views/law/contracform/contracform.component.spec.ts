import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContracformComponent } from './contracform.component';

describe('ContracformComponent', () => {
  let component: ContracformComponent;
  let fixture: ComponentFixture<ContracformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ContracformComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContracformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
