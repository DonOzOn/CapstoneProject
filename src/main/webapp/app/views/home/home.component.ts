import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AddressService } from 'app/core/address/address.service';
import { PostService } from 'app/core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  config: any;
  count: any;
  listPost: any[] = [];
  choose = [{ value: '', name: 'Toàn bộ' }, { value: 1, name: 'Mua bán' }, { value: 2, name: 'Cho thuê' }];
  chooseForm = this.fb.group({
    choose: ['']
  });
  listProvinces = [];
  post: PostRespone[] = [];
  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next'
  };
  responsiveOptions;
  product = [{ title: 'Hồ Chí Minh' }, { title: 'Hà Nội' }, { title: 'Đà Nẵng' }, { title: 'Hải Phòng' }];
  constructor(private addressService: AddressService, private fb: FormBuilder, private postService: PostService) {
    for (let i = 0; i < this.count; i++) {
      this.listPost.push({
        id: i + 1,
        value: 'items number' + (i + 1)
      });
    }
    this.config = {
      itemsPerPage: 5,
      currentPage: 1,
      totalItems: this.count
    };
    this.responsiveOptions = [
      {
        breakpoint: '1920px',
        numVisible: 5,
        numScroll: 5
      },
      {
        breakpoint: '1600px',
        numVisible: 4,
        numScroll: 4
      },
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

  pageChanged(event) {
    this.config.currentPage = event;
  }

  ngOnInit() {
    this.getProvince();
    this.getListPostProduct();
  }

  getListPostProduct() {
    this.postService.query().subscribe(res => {
      this.post = res.body;
      // eslint-disable-next-line
      console.log('List  : ', this.post);
    });
  }
  /*  get all provinces */
  getProvince() {
    this.addressService.filterProvince().subscribe((res: any) => {
      this.listProvinces = res.body;
      // eslint-disable-next-line
      console.log('List all post : ', this.listProvinces);
    });
  }

  /*  get total page*/
  getTotalPage() {
    this.postService.query().subscribe(res => {
      this.count = res.body.length;
      return this.count;
    });
  }
  onChange($event) {}
}
