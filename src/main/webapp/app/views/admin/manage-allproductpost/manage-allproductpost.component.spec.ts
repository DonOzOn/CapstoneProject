import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ManageAllProductpostComponent } from './manage-allproductpost';

describe('ManageproductpostComponent', () => {
  let component: ManageAllProductpostComponent;
  let fixture: ComponentFixture<ManageAllProductpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ManageAllProductpostComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageAllProductpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
