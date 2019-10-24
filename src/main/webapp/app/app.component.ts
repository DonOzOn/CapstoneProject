import { Component, OnInit, HostListener, Inject } from '@angular/core';
import { trigger, state, transition, style, animate } from '@angular/animations';
import { DOCUMENT } from '@angular/common';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  animations: [
    trigger('fade', [state('void', style({ opacity: 0 })), transition(':enter', [animate(300)]), transition(':leave', [animate(500)])])
  ]
})
export class AppComponent implements OnInit {
  title = 'RealEstateBrokerageCient';
  constructor(@Inject(DOCUMENT) document) {}

  ngOnInit() {}
}
