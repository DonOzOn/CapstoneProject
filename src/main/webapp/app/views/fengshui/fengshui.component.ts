import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-fengshui',
  templateUrl: './fengshui.component.html',
  styleUrls: ['./fengshui.component.scss']
})
export class FengshuiComponent implements OnInit {
  listYear: number[] = [];
  gender: string[] = ['Nam', 'Nữ'];
  yearitem;
  formdata;
  genderitem;
  constructor() {}

  ngOnInit() {
    for (let i = 1945; i < 2019; i++) {
      this.listYear.push(i);
    }
    this.formdata = new FormGroup({
      yearitem: new FormControl('lalalala'),
      genderitem: new FormControl('Nam')
    });
  }
  onClickSubmit(data) {
    this.yearitem = data.yearitem;
  }
}
