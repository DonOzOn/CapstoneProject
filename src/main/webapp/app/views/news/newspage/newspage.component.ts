import { Component, OnInit } from '@angular/core';
import { NewsService } from 'app/core/news/news.service';
import { INews, News } from 'app/core/news/news.model';
import { SERVER_API_URL } from 'app/app.constants';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-newspage',
  templateUrl: './newspage.component.html',
  styleUrls: ['./newspage.component.scss']
})
export class NewspageComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  listNews: INews[];

  countNew: any;
  list8News: INews[];
  listNewsFirstElement: INews[];
  list4NewsLastElement: INews[];
  latestNew: INews;
  /* pagination */
  public directionLinks = true;
  public autoHide = false;
  public responsive = true;
  public maxSize = 5;
  listPagination: any[] = [];
  config: any;
  public labels: any = {
    previousLabel: 'Trang trước',
    nextLabel: 'Trang kế'
  };

  listContent: any = [];
  listnewdetail: News;

  constructor(private newService: NewsService, private activatedRoute: ActivatedRoute) {
    for (let i = 0; i < this.countNew; i++) {
      this.listPagination.push({
        id: i + 1,
        value: 'items number' + (i + 1)
      });
    }
    this.config = {
      itemsPerPage: 3,
      currentPage: 1,
      totalItems: this.countNew
    };
  }

  ngOnInit() {
    this.getlistNews();
    this.getTotalPage();
    this.getlist4News();
    // eslint-disable-next-line
    console.log('dsfdfdf: ', this.listNews);
  }

  pageChanged(event) {
    this.config.currentPage = event;
  }
  /*  get total page in pagination*/
  getTotalPage() {
    this.newService.getListNews().subscribe(res => {
      this.countNew = res.body.length;
      // eslint-disable-next-line
      console.log('totalItem : ', this.countNew);
      return this.countNew;
    });
  }
  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      // eslint-disable-next-line
      console.log('get news: ', res.body);
      this.listNews = res.body;
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

  /*  get  list 4 new*/
  getlist4News() {
    this.newService.getListNews().subscribe(res => {
      this.list8News = res.body;
      this.list8News.sort(function(obj1, obj2) {
        return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
      });
      this.listNews = res.body.slice(5, res.body.length);
      this.list8News = res.body.slice(0, 5);
      // eslint-disable-next-line
      console.log('Listnew  : ', this.list8News);
      this.listNewsFirstElement = this.list8News.slice(0, 1);
      // eslint-disable-next-line
      console.log('List4newFirst  : ', this.listNewsFirstElement);
      this.list4NewsLastElement = this.list8News.slice(1, 5);
      // eslint-disable-next-line
      console.log('List4newLast  : ', this.list4NewsLastElement);
    });
  }
}
