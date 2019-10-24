import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagereviewpostComponent } from './managereviewpost.component';

describe('ManagereviewpostComponent', () => {
  let component: ManagereviewpostComponent;
  let fixture: ComponentFixture<ManagereviewpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ManagereviewpostComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagereviewpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
