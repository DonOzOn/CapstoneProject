import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LawrentComponent } from './lawrent.component';

describe('LawrentComponent', () => {
  let component: LawrentComponent;
  let fixture: ComponentFixture<LawrentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LawrentComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LawrentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
