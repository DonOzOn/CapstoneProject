import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NewsService } from 'app/core/news/news.service';
import { INews } from 'app/core/news/news.model';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
  selector: 'app-newsdetail',
  templateUrl: './newsdetail.component.html',
  styleUrls: ['./newsdetail.component.scss']
})
export class NewsdetailComponent implements OnInit {
  id: any;
  detailNew: INews;
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  constructor(private newService: NewsService, private activatedRoute: ActivatedRoute, private router: Router) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.detailNew = res.detailNew;
      // eslint-disable-next-line
      console.log('sdsdasdasd: ', res.detailNew);
    });
  }
}
