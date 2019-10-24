import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LawsellComponent } from './lawsell.component';

describe('LawsellComponent', () => {
  let component: LawsellComponent;
  let fixture: ComponentFixture<LawsellComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LawsellComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LawsellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
