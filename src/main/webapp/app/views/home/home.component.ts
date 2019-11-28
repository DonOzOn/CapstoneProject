import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  cars: any[];
  children = [
    { title: 'Hồ Chí Minh' },
    { title: 'Hà Nội' },
    { title: 'Đà Nẵng' },
    { title: 'Hải Phòng' },
    { title: 'Child 5' },
    { title: 'Child 1' },
    { title: 'Child 2' },
    { title: 'Child 3' },
    { title: 'Child 4' },
    { title: 'Child 5' },
    { title: 'Child 6' },
    { title: 'Child 7' },
    { title: 'Child 8' }
  ];
  responsiveOptions;
  product = [{ title: 'Hồ Chí Minh' }, { title: 'Hà Nội' }, { title: 'Đà Nẵng' }, { title: 'Hải Phòng' }];
  constructor() {
    this.responsiveOptions = [
      {
        breakpoint: '1024px',
        numVisible: 3,
        numScroll: 3
      },
      {
        breakpoint: '768px',
        numVisible: 2,
        numScroll: 2
      },
      {
        breakpoint: '560px',
        numVisible: 1,
        numScroll: 1
      }
    ];
  }

  ngOnInit() {
    this.cars = this.children;
  }
}
