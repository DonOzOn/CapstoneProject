/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { GotoTopComponent } from './gotoTop.component';

describe('GotoTopComponent', () => {
  let component: GotoTopComponent;
  let fixture: ComponentFixture<GotoTopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GotoTopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GotoTopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
