import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { PostService } from '../../core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';
import { ActivatedRoute, Router } from '@angular/router';
import { Ng7DynamicBreadcrumbService } from 'ng7-dynamic-breadcrumb';
import { NewsService } from 'app/core/news/news.service';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
// import { debounceTime, distinctUntilChanged, tap } from 'rxjs/operators';

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
  text: '';
  filterForm = this.fb.group({
    postType: [''],
    price: [''],
    area: ['']
  });
  config: any;
  count: any;
  listPost: any[] = [];
  listPost2: any;
  listNews: any[] = [];
  post: PostRespone[] = [];
  filteredProducts = [];
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
    // if (this.route.params.textSearch) {
    //   // eslint-disable-next-line
    //   console.log('textSearch: ', this.route.params.textSearch);
    // }
    const breadcrumb = { customText: 'This is Custom Text', dynamicText: 'Level 2 ' };
    this.ng7DynamicBreadcrumbService.updateBreadcrumbLabels(breadcrumb);
    // this.getListPostProduct();
    this.getlistNews();
    this.activatedRoute.firstChild.data.subscribe(res => {
      this.filteredProducts = res.typeSearch.body;
      this.post = this.filteredProducts;
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    });
    this.filterFunction();

    // this.price.valueChanges
    //   .pipe(
    //     tap(() =>
    //       // eslint-disable-next-line
    //       console.log('price value ',  this.price.value)
    //     ),
    //     tap(() => {
    //       switch (this.price.value) {
    //         case 1:
    //           this.post = this.filteredProducts;
    //           break;
    //         case 2:
    //           this.filterPrice(0, 300000000);
    //           break;
    //         case 3:
    //           this.filterPrice(300000000, 500000000);
    //           break;
    //         default:
    //           break;
    //       }
    //     })
    //   )
    //   .subscribe();
  }

  filterPrice(from: any, to: any) {
    if (to === 0) {
      this.post = this.filteredProducts.filter(postItem => {
        // eslint-disable-next-line
        return parseInt(postItem.productResponseDTO.price) >= from;
      });
    } else {
      this.post = this.filteredProducts.filter(postItem => {
        // eslint-disable-next-line
        return parseInt(postItem.productResponseDTO.price) >= from && parseInt(postItem.productResponseDTO.price) <= to;
      });
    }
  }

  filterArea(from: any, to: any) {
    this.post = this.filteredProducts.filter(postItem => {
      // eslint-disable-next-line
      return parseInt(postItem.productResponseDTO.area) >= from && parseInt(postItem.productResponseDTO.area) <= to;
    });
  }

  filterFunction() {
    this.filterForm.controls.price.valueChanges
      .pipe(
        debounceTime(200),
        distinctUntilChanged()
      )
      .subscribe(val => {
        switch (val) {
          case '1':
            this.post = this.filteredProducts;
            break;
          case '2':
            this.filterPrice(0, 300000000);
            break;
          case '3':
            this.filterPrice(300000000, 500000000);
            break;
          case '4':
            this.filterPrice(500000000, 700000000);
            break;
          case '5':
            this.filterPrice(700000000, 1000000000);
            break;
          case '6':
            this.filterPrice(1000000000, 3000000000);
            break;
          case '7':
            this.filterPrice(3000000000, 5000000000);
            break;
          case '8':
            this.filterPrice(5000000000, 7000000000);
            break;
          case '9':
            this.filterPrice(7000000000, 10000000000);
            break;
          case '10':
            this.filterPrice(10000000000, 20000000000);
            break;
          case '11':
            this.filterPrice(20000000000, 30000000000);
            break;
          case '12':
            this.filterPrice(30000000000, 50000000000);
            break;
          case '13':
            this.filterPrice(50000000000, 0);
            break;
          default:
            break;
        }
      });
  }

  /**
   * Redirects to
   * @param uri
   */
  redirectTo(uri: string) {
    this.router.navigateByUrl('/404', { skipLocationChange: true }).then(() => this.router.navigate([uri]));
  }

  /*  get all product post */
  getListPostProduct() {
    this.postService.query().subscribe(res => {
      this.post = res.body;
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
