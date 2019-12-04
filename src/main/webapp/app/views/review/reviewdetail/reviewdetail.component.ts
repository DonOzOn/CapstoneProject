import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../../../core/review/review.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IReview } from 'app/core/review/review.model';

@Component({
  selector: 'app-reviewdetail',
  templateUrl: './reviewdetail.component.html',
  styleUrls: ['./reviewdetail.component.scss']
})
export class ReviewdetailComponent implements OnInit {
  detailReview: IReview;
  reviewDetail: any;
  id: any;
  constructor(private newService: ReviewService, private activatedRoute: ActivatedRoute, private router: Router) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.reviewDetail = res.body;
      // eslint-disable-next-line
      console.log('sdsdasdasd: ', this.reviewDetail);
    });
  }
}
