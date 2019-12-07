import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CareYouComponent } from './care-you.component';

describe('CareYouComponent', () => {
  let component: CareYouComponent;
  let fixture: ComponentFixture<CareYouComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CareYouComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CareYouComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
