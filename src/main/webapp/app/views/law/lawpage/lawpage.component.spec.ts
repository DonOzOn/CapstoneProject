import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LawpageComponent } from './lawpage.component';

describe('LawpageComponent', () => {
  let component: LawpageComponent;
  let fixture: ComponentFixture<LawpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LawpageComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LawpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
