import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NewsService } from 'app/core/news/news.service';
import { INews } from 'app/core/news/news.model';

@Component({
  selector: 'app-newsdetail',
  templateUrl: './newsdetail.component.html',
  styleUrls: ['./newsdetail.component.scss']
})
export class NewsdetailComponent implements OnInit {
  id: any;
  detailNew: INews;
  constructor(private newService: NewsService, private activatedRoute: ActivatedRoute, private router: Router) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.detailNew = res.detailNew;
      // eslint-disable-next-line
      console.log('sdsdasdasd: ', res.detailNew);
    });
  }
}
