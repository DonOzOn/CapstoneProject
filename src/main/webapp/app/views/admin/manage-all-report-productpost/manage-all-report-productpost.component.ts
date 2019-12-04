import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ManageAllReportPostComponent } from './manage-all-report-productpost';

describe('ManageproductpostComponent', () => {
  let component: ManageAllReportPostComponent;
  let fixture: ComponentFixture<ManageAllReportPostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ManageAllReportPostComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageAllReportPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
