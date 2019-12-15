/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { NotificationreviewComponent } from './notificationreview.component';

describe('NotificationreviewComponent', () => {
  let component: NotificationreviewComponent;
  let fixture: ComponentFixture<NotificationreviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NotificationreviewComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotificationreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
