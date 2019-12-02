import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { AddressService } from 'app/core/address/address.service';
import { PostService } from 'app/core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';
import { NewsService } from 'app/core/news/news.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  list4News: any[] = [];
  count: any;
  searchText = new FormControl('');
  choose = [{ value: '', name: 'Toàn bộ' }, { value: 1, name: 'Mua bán' }, { value: 2, name: 'Cho thuê' }];
  chooseForm = this.fb.group({
    choose: ['']
  });
  listProvinces = [];
  post: PostRespone[] = [];
  /* pagination */
  public directionLinks = true;
  public autoHide = false;
  public responsive = true;
  public maxSize = 5;
  listPagination: any[] = [];
  config: any;
  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next'
  };
  responsiveOptions;

  constructor(
    private addressService: AddressService,
    private fb: FormBuilder,
    private postService: PostService,
    private newService: NewsService,
    private router: Router
  ) {
    for (let i = 0; i < this.count; i++) {
      this.listPagination.push({
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
  /*  get total page in pagination*/
  getTotalPage() {
    this.postService.query().subscribe(res => {
      this.count = res.body.length;
      return this.count;
    });
  }
  pageChanged(event) {
    this.config.currentPage = event;
  }

  ngOnInit() {
    this.getProvince();
    this.getlist4News();
    this.getListPostProduct();
  }

  /**
   * Gets list post product
   */
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

  /**
   * Go to news
   * @param id
   */
  goToNews(id: any) {
    // tslint:disable-next-line: no-unused-expression
    this.router.navigate(['/news', id, 'detail']);
  }

  /*  get  list 4 new*/
  getlist4News() {
    this.newService.getListNews().subscribe(res => {
      this.list4News = res.body;
      // eslint-disable-next-line
      console.log('Listnew  : ', this.list4News);
      this.list4News.sort(function(obj1, obj2) {
        return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
      });
      this.list4News = res.body.slice(0, 4);
    });
  }

  onChange($event) {}

  /**
   * Searchs
   */
  search() {
    this.router.navigate(['/listproduct', 'fullTextSearch', this.searchText.value]);
  }
}
