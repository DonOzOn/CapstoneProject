import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../../../core/review/review.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IReview } from 'app/core/review/review.model';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
  selector: 'app-reviewdetail',
  templateUrl: './reviewdetail.component.html',
  styleUrls: ['./reviewdetail.component.scss']
})
export class ReviewdetailComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  id: any;
  detailReview: IReview;
  constructor(private reviewservice: ReviewService, private activatedRoute: ActivatedRoute, private router: Router) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.detailReview = res.detailNew;
      // eslint-disable-next-line
      console.log('sdsdasdasd: ', this.detailReview);
    });
  }
}
