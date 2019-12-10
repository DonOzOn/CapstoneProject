import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { IPar } from 'app/core/par/par.model';
import { ParService } from 'app/core/par/parService';
import { IDirecHouse } from 'app/core/par/model/direcHouse.model';
import { IPostRespone } from 'app/core/post/model/postRespone.model';
import { PostService } from 'app/core/post/post.service';

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
  listPostByDirection: IPostRespone[];
  constructor(private parService: ParService, private postService: PostService) {}

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
        this.postService.getByDirectionHouse(this.direction.id).subscribe(resPost => {
          this.listPostByDirection = resPost.body;
          // eslint-disable-next-line
          console.log('List Product post by direction : ', this.listPostByDirection);
        });
        this.isMan = true;
      });
    } else {
      this.parService.findwoman(data.yearitem).subscribe(res => {
        this.direction = res;
        // eslint-disable-next-line
        console.log('this.direction: ', res);
        this.postService.getByDirectionHouse(this.direction.id).subscribe(resPost => {
          this.listPostByDirection = resPost.body;
          // eslint-disable-next-line
          console.log('List Product post by direction : ', this.listPostByDirection);
        });
        this.isMan = false;
      });
    }
  }
}
