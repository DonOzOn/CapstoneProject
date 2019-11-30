import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { NewsService } from 'app/core/service/news.service';
import { AddressService } from 'app/core/address/address.service';
import { PostService } from 'app/core/post/post.service';
import { SERVER_API_URL } from 'app/app.constants';
import { PostRespone } from 'app/core/post/model/postRespone.model';

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
  listNews: any[] = [];
  listProvinces = [];
  post: PostRespone[];
  choose = [{ value: '', name: 'Toàn bộ' }, { value: 1, name: 'Mua bán' }, { value: 2, name: 'Cho thuê' }];
  chooseForm = this.fb.group({
    choose: ['']
  });

  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next'
  };

  responsiveOptions;
  constructor(
    private postService: PostService,
    private fb: FormBuilder,
    private newService: NewsService,
    private addressService: AddressService
  ) {
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
    this.getListPostProduct();
    this.getProvince();
    this.getlistNews();
  }

  /*  get all product post */
  getListPostProduct() {
    this.postService.query().subscribe(res => {
      this.post = res.body;
      // eslint-disable-next-line
      console.log('List all post : ', this.post);
    });
  }

  /*  get total page*/
  getTotalPage() {
    this.postService.query().subscribe(res => {
      this.count = res.body.length;
      return this.count;
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

  /*  get  list 4 new*/
  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      this.listNews = res.data.rows;
      this.listNews.sort(function(obj1, obj2) {
        return obj2.timeCreate - obj1.timeCreate;
      });
      this.listNews = res.data.rows.slice(0, 4);
    });
  }
  onChange($event) {}
}
