import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lawsell',
  templateUrl: './lawsell.component.html',
  styleUrls: ['./lawsell.component.scss']
})
export class LawsellComponent implements OnInit {
  toggle1 = false;
  toggle2 = false;
  toggle3 = false;
  toggle4 = false;
  toggle5 = false;
  toggle6 = false;
  constructor() {}

  ngOnInit() {}
  changeType(num: number) {
    switch (num) {
      case 1:
        this.toggle1 = !this.toggle1;
        break;
      case 2:
        this.toggle2 = !this.toggle2;
        break;
      case 3:
        this.toggle3 = !this.toggle3;
        break;
      case 4:
        this.toggle4 = !this.toggle4;
        break;
      case 5:
        this.toggle5 = !this.toggle5;
        break;
      case 6:
        this.toggle6 = !this.toggle6;
        break;
    }
  }
}
