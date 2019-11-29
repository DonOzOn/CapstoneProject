import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { PostService } from '../../core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';
import { ActivatedRoute, Router } from '@angular/router';
import { ListProductPostService } from 'app/core/service/listproductpost.service';
import { Ng7DynamicBreadcrumbService } from 'ng7-dynamic-breadcrumb';
import { NewsService } from 'app/core/news/news.service';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.scss']
})
export class ListproductComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  breadcrumbConfig: object = {
    bgColor: '#ebebeb;',
    fontSize: '18px',
    fontColor: '#0275d8',
    lastLinkColor: 'black',
    symbol: ' ▶ '
  };
  config: any;
  count: any;
  listPost: any[] = [];
  listPost2: any;
  listNews: any[] = [];
  post: PostRespone[];
  choose = [
    { value: 1, name: 'Mới nhất' },
    { value: 2, name: 'Cũ nhất' },
    { value: 3, name: 'Giá cao nhất' },
    { value: 4, name: 'Giá thấp nhất' }
  ];
  chooseForm = this.fb.group({
    choose: ['']
  });
  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next'
  };
  constructor(
    private listProductPostService: ListProductPostService,
    private newService: NewsService,
    private postService: PostService,
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private ng7DynamicBreadcrumbService: Ng7DynamicBreadcrumbService
  ) {
    for (let i = 0; i < this.count; i++) {
      this.listPost.push({
        id: i + 1,
        value: 'items number' + (i + 1)
      });
    }
    this.config = {
      itemsPerPage: 4,
      currentPage: 1,
      totalItems: this.count
    };
  }
  pageChanged(event) {
    this.config.currentPage = event;
  }

  ngOnInit() {
    const breadcrumb = { customText: 'This is Custom Text', dynamicText: 'Level 2 ' };
    this.ng7DynamicBreadcrumbService.updateBreadcrumbLabels(breadcrumb);
    // this.getListPostProduct();
    this.getlistNews();
    this.activatedRoute.firstChild.data.subscribe(res => {
      this.post = res.typeSearch.body;
    });

    this.activatedRoute.firstChild.data.subscribe(res => {
      this.post = res.typeChildSearch.body;
    });
    // this.redirectTo(this.activatedRoute.snapshot.url.toString());
    // eslint-disable-next-line
    console.log('post active', this.activatedRoute.data);
  }

  redirectTo(uri: string) {
    this.router.navigateByUrl('/404', { skipLocationChange: true }).then(() => this.router.navigate([uri]));
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
  /*  get  list 4 new*/
  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      this.listNews = res.body;
      this.listNews.sort(function(obj1, obj2) {
        return obj2.timeCreate - obj1.timeCreate;
      });
      this.listNews = res.body.slice(0, 4);
    });
  }
  /*  change sort */
  onChange($deviceValue) {
    switch (this.chooseForm.controls.choose.value) {
      case 1: {
        this.post.sort(function(obj1: any, obj2: any) {
          return new Date(obj2.productPostResponseDTO.createdDate).valueOf() - new Date(obj1.productPostResponseDTO.createdDate).valueOf();
        });
        break;
      }
      case 2: {
        this.post.sort(function(obj1: any, obj2: any) {
          return new Date(obj1.productPostResponseDTO.createdDate).valueOf() - new Date(obj2.productPostResponseDTO.createdDate).valueOf();
        });
        break;
      }
      case 3: {
        this.post.sort(function(obj1: any, obj2: any) {
          return obj1.productPostResponseDTO.product.price - obj2.productPostResponseDTO.product.price;
        });
        break;
      }
      case 4: {
        this.post.sort(function(obj1: any, obj2: any) {
          return obj2.productPostResponseDTO.product.price - obj1.productPostResponseDTO.product.price;
        });
        break;
      }
      default: {
        break;
      }
    }
  }
}
