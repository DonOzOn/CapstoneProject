import { Component, OnInit } from '@angular/core';
import { NewsService } from 'app/core/news/news.service';
import { SERVER_API_URL } from 'app/app.constants';
import { Router } from '@angular/router';

@Component({
  selector: 'app-law',
  templateUrl: './law.component.html',
  styleUrls: ['./law.component.scss']
})
export class LawComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  list4News: any[] = [];
  constructor(private newService: NewsService, private router: Router) {}
  ngOnInit() {
    this.getlist4News();
  }
  /*  get  list 4 new*/
  getlist4News() {
    this.newService.getListNews().subscribe(res => {
      this.list4News = res.body;
      // eslint-disable-next-line
      console.log('Listnew  : ', this.list4News);
      this.list4News.sort(function(obj1, obj2) {
        return obj2.timeCreate - obj1.timeCreate;
      });
      this.list4News = res.body.slice(0, 4);
    });
  }
  goToNews(id: any) {
    // tslint:disable-next-line: no-unused-expression
    this.router.navigate(['/news', id, 'detail']);
  }
}
