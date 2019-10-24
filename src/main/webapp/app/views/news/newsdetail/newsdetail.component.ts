import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NewsService } from 'app/core/service/news.service';

@Component({
  selector: 'app-newsdetail',
  templateUrl: './newsdetail.component.html',
  styleUrls: ['./newsdetail.component.scss']
})
export class NewsdetailComponent implements OnInit {
  id: any;
  detailNew: any;
  constructor(private newService: NewsService, private activatedRoute: ActivatedRoute, private router: Router) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.detailNew = res.detailNew.data;
      console.log(this.detailNew);
    });
  }
}
