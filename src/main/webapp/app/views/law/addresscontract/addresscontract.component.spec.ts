import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddresscontractComponent } from './addresscontract.component';

describe('AddresscontractComponent', () => {
  let component: AddresscontractComponent;
  let fixture: ComponentFixture<AddresscontractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AddresscontractComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddresscontractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
