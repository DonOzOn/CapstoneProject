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
  list4News: any[] = [];
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
      itemsPerPage: 10,
      currentPage: 1,
      totalItems: this.countNew,
    };
  }

  ngOnInit() {
    this.getlistNews();
    this.getTotalPage();
    this.getlist4News();
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
      this.listNews = res.body;
    });
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
}
