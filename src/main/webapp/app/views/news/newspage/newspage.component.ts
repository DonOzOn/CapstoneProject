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
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  listNews: INews[];
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
