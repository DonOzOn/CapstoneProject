import { Component, OnInit } from '@angular/core';
import { FlickityChildDirective } from 'ngx-flickity';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
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
  product = [{ title: 'Hồ Chí Minh' }, { title: 'Hà Nội' }, { title: 'Đà Nẵng' }, { title: 'Hải Phòng' }];
  constructor() {}

  ngOnInit() {}
}
