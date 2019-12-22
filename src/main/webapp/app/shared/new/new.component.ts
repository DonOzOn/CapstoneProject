import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NewsService } from 'app/core/news/news.service';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.scss']
})
export class NewComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  list4News: any[] = [];
  constructor(private router: Router, private newService: NewsService) {}

  ngOnInit() {
    this.getlist4News();
  }

  /*  get  list 4 new*/
  getlist4News() {
    this.newService.getListNews().subscribe(res => {
      this.list4News = res.body;
      this.list4News.sort(function(obj1, obj2) {
        return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
      });
      this.list4News = res.body.slice(0, 5);
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
}
