import { Component, OnInit } from '@angular/core';
import { NewsService } from 'app/core/news/news.service';

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
      this.listNews = res.body;
    });
  }
}
