import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { NewsService } from 'app/core/service/news.service';
import { PostService } from '../../core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.scss']
})
export class ListproductComponent implements OnInit {
  config: any;
  count: any;
  listPost: any[] = [];
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
  constructor(private postService: PostService, private newService: NewsService, private fb: FormBuilder) {
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
    this.getListPostProduct();
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
