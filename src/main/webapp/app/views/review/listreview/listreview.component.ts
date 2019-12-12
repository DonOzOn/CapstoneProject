import { Component, OnInit } from '@angular/core';
import { ReviewService } from 'app/core/review/review.service';
import { IReview } from 'app/core/review/review.model';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-listreview',
  templateUrl: './listreview.component.html',
  styleUrls: ['./listreview.component.scss']
})
export class ListreviewComponent implements OnInit {
  reviews: IReview[];
  countReview: any;
  /* pagination */
  listPagination: any[] = [];
  config: any;
  public directionLinks = true;
  public autoHide = false;
  public responsive = true;
  public maxSize = 5;
  public labels: any = {
    previousLabel: 'Trước',
    nextLabel: 'Sau'
  };
  constructor(private reviewService: ReviewService, private activatedRoute: ActivatedRoute, private router: Router) {
    for (let i = 0; i < this.countReview; i++) {
      this.listPagination.push({
        id: i + 1,
        value: 'items number' + (i + 1)
      });
    }
    this.config = {
      itemsPerPage: 10,
      currentPage: 1,
      totalItems: this.countReview
    };
  }

  /*  get total page in pagination*/
  getTotalPage() {
    this.reviewService.getListReview().subscribe(res => {
      this.countReview = res.body.length;
      // // eslint-disable-next-line
      // console.log('count: ', this.countReview);
      return this.countReview;
    });
  }
  pageChanged(event) {
    this.config.currentPage = event;
  }
  ngOnInit() {
    this.getTotalPage();
    // this.getListReview();
    this.activatedRoute.data.subscribe(res => {
      this.reviews = res.typeSearch.body;
      // eslint-disable-next-line
      console.log('reviews: ', this.reviews);
    });
  }

  /**
   * Gets list review
   */
  getListReview() {
    this.reviewService.getListReview().subscribe(res => {
      this.reviews = res.body;
      // eslint-disable-next-line
      console.log('review: ', this.reviews);
    });
  }
}
