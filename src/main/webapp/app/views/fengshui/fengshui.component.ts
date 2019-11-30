import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { IPar } from 'app/core/par/par.model';
import { ParService } from 'app/core/par/parService';

@Component({
  selector: 'app-fengshui',
  templateUrl: './fengshui.component.html',
  styleUrls: ['./fengshui.component.scss']
})
export class FengshuiComponent implements OnInit {
  listYear: number[] = [];
  gender: string[] = ['Nam', 'Nữ'];
  par: IPar;
  yearitem;
  formdata;
  genderitem;
  constructor(private parService: ParService) {}

  ngOnInit() {
    for (let i = 1945; i < 2019; i++) {
      this.listYear.push(i);
    }
    this.formdata = new FormGroup({
      yearitem: new FormControl('1945'),
      genderitem: new FormControl('Nữ')
    });
  }

  onClickSubmit(data) {
    this.yearitem = data.yearitem;
    // eslint-disable-next-line
    console.log('gender : ', this.formdata.controls['genderitem'].value);
    if (this.formdata.controls['genderitem'].value === 'Nam') {
      // eslint-disable-next-line
      console.log('gender : ', this.formdata.controls['genderitem'].value);
      this.parService.findman(data.yearitem).subscribe(res => {
        // eslint-disable-next-line
        console.log('res : ', res);
        this.par = res.body;
      });
      // eslint-disable-next-lines
      console.log('res paman: ', this.par);
    } else {
      // eslint-disable-next-line
      console.log('gender : ', this.formdata.controls['genderitem'].value);
      this.parService.findwoman(data.yearitem).subscribe(res => {
        // eslint-disable-next-line
        console.log('res : ', res);
        this.par = res.body;
      });
      // eslint-disable-next-line
      console.log('res paman: ', this.par);
    }
  }
}
