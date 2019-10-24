import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FengshuiComponent } from './fengshui.component';

describe('FengshuiComponent', () => {
  let component: FengshuiComponent;
  let fixture: ComponentFixture<FengshuiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FengshuiComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FengshuiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
