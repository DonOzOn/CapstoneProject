import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagereAllReviewpostComponent } from './manage-all-reviewpost.component';

describe('ManagereviewpostComponent', () => {
  let component: ManagereAllReviewpostComponent;
  let fixture: ComponentFixture<ManagereAllReviewpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ManagereAllReviewpostComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagereAllReviewpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
