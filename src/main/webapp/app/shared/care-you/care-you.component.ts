import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
  selector: 'app-care-you',
  templateUrl: './care-you.component.html',
  styleUrls: ['./care-you.component.scss']
})
export class CareYouComponent implements OnInit {
  @Input() listSuggest: PostRespone[];
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  constructor(private activatedRoute: ActivatedRoute) {}
  ngOnInit() {}
}
