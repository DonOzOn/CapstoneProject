import { NewsService } from './../../../core/service/news.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-newspage',
  templateUrl: './newspage.component.html',
  styleUrls: ['./newspage.component.scss']
})
export class NewspageComponent implements OnInit {
  listNews: any[] = [];
  constructor(private newService: NewsService) {}

  ngOnInit() {
    this.getlistNews();
  }

  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      console.log(res);
      this.listNews = res.data.rows;
    });
  }
}
