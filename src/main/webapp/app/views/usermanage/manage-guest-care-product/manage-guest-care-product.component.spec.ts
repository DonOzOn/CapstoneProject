import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageGuestCareComponent } from './manage-guest-care-product.component';

describe('ManageproductpostComponent', () => {
  let component: ManageGuestCareComponent;
  let fixture: ComponentFixture<ManageGuestCareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ManageGuestCareComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageGuestCareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
