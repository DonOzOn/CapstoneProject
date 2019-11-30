import { Component, OnInit } from '@angular/core';
import { NewsService } from 'app/core/news/news.service';
import { INews } from 'app/core/news/news.model';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
  selector: 'app-newspage',
  templateUrl: './newspage.component.html',
  styleUrls: ['./newspage.component.scss']
})
export class NewspageComponent implements OnInit {
  config: any;
  count: any;
  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next'
  };
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  listNews: INews[] = [];
  constructor(private newService: NewsService) {
    // for (let i = 0; i < this.count; i++) {
    //   this.listNews.push({
    //     id: i + 1,
    //     value: 'items number' + (i + 1);
    //   });
    // }
    this.config = {
      itemsPerPage: 4,
      currentPage: 1,
      totalItems: this.count
    };
  }

  ngOnInit() {
    this.getlistNews();
  }
  pageChanged(event) {
    this.config.currentPage = event;
  }
  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      this.listNews = res.body;
    });
  }
  /*  get total page*/
  getTotalPage() {
    this.newService.getListNews().subscribe(res => {
      this.count = res.body.length;
      return this.count;
    });
  }
  /*  get  list 4 new*/
  getlist4New() {
    this.newService.getListNews().subscribe(res => {
      this.listNews = res.body;
      // this.listNews.sort(function(obj1, obj2) {
      //   // return obj2.createdDate - obj1.createdDate;
      // });
      this.listNews = res.body.slice(0, 4);
    });
  }
}
