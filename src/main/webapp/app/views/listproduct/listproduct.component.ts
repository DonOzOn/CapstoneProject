import { Component, OnInit } from '@angular/core';
import { ListProductPostService } from 'app/core/service/listproductpost.service';
import { FormBuilder } from '@angular/forms';
import { debounceTime, distinctUntilChanged, count } from 'rxjs/operators';
import { NewsService } from 'app/core/service/news.service';

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
  itemsTag = ['Pizza', 'Pasta', 'Parmesan'];
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
  constructor(private listProductPostService: ListProductPostService, private newService: NewsService, private fb: FormBuilder) {
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
    this.getListPost();
    this.getlistNews();
    this.handelChange();
  }
  getListPost() {
    this.listProductPostService.getListProductPost().subscribe(res => {
      this.listPost = res.data.rows;
    });
  }
  getTotalPage() {
    this.listProductPostService.getListProductPost().subscribe(res => {
      this.count = res.data.count;
      return this.count;
    });
  }
  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      this.listNews = res.data.rows;
      this.listNews.sort(function(obj1, obj2) {
        return obj2.timeCreate - obj1.timeCreate;
      });
      this.listNews = res.data.rows.slice(0, 4);
    });
  }
  handelChange() {
    this.chooseForm.controls.choose.valueChanges
      .pipe(
        debounceTime(200),
        distinctUntilChanged()
      )
      .subscribe(val => {
        switch (val) {
          case 1: {
            this.listPost.sort(function(obj1, obj2) {
              return obj2.timeCreate - obj1.timeCreate;
            });
            break;
          }
          case 2: {
            this.listPost.sort(function(obj1, obj2) {
              return obj1.timeCreate - obj2.timeCreate;
            });
            break;
          }
          case 3: {
            this.listPost.sort(function(obj1, obj2) {
              return obj2.price - obj1.price;
            });
            break;
          }
          case 4: {
            this.listPost.sort(function(obj1, obj2) {
              return obj1.price - obj2.price;
            });
            break;
          }
          default: {
            break;
          }
        }
      });
  }
  parse(value: any): Date | null {
    if (typeof value === 'string' && value.includes('/')) {
      const str = value.split('/');

      const year = Number(str[2]);
      const month = Number(str[1]) - 1;
      const date = Number(str[0]);

      return new Date(year, month, date);
    } else if (typeof value === 'string' && value === '') {
      return new Date();
    }
    const timestamp = typeof value === 'number' ? value : Date.parse(value);
    return isNaN(timestamp) ? null : new Date(timestamp);
  }
}
