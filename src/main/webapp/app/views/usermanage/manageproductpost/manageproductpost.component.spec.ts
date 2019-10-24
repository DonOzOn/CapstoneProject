import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageproductpostComponent } from './manageproductpost.component';

describe('ManageproductpostComponent', () => {
  let component: ManageproductpostComponent;
  let fixture: ComponentFixture<ManageproductpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ManageproductpostComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageproductpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
