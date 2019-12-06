import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { IPar } from 'app/core/par/par.model';
import { ParService } from 'app/core/par/parService';
import { IDirecHouse } from 'app/core/par/model/direcHouse.model';
import { faLeaf } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-fengshui',
  templateUrl: './fengshui.component.html',
  styleUrls: ['./fengshui.component.scss']
})
export class FengshuiComponent implements OnInit {
  listYear: number[] = [];
  gender: string[] = ['Nam', 'Nữ'];
  par: IPar;
  direction: IDirecHouse;
  yearitem;
  formdata;
  genderitem;
  searchPar: boolean;
  isMan: boolean;
  constructor(private parService: ParService) {}

  ngOnInit() {
    for (let i = 1945; i <= 2019; i++) {
      this.listYear.push(i);
    }
    this.formdata = new FormGroup({
      yearitem: new FormControl('1945'),
      genderitem: new FormControl('Nam')
    });
    this.searchPar = false;
  }

  onClickSubmit(data) {
    this.searchPar = true;
    this.yearitem = this.formdata.controls['yearitem'].value;
    this.genderitem = this.formdata.controls['genderitem'].value;
    if (this.formdata.controls['genderitem'].value === 'Nam') {
      this.parService.findman(data.yearitem).subscribe(res => {
        // eslint-disable-next-line
        console.log('res body : ', res);
        this.direction = res;
        this.isMan = true;
      });
    } else {
      this.parService.findwoman(data.yearitem).subscribe(res => {
        // eslint-disable-next-line
        console.log('res body : ', res);
        this.direction = res;
        this.isMan = false;
      });
    }
    // eslint-disable-next-line
    console.log('res paman: ', this.direction);
  }
}
