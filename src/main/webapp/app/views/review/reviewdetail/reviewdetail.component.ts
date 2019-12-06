import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../../../core/review/review.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IReview } from 'app/core/review/review.model';
import { SERVER_API_URL } from 'app/app.constants';
import { IUser } from 'app/core/user/user.model';
import { LikedReview } from 'app/core/liked/model/liked-review.model';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { LikedService } from 'app/core/liked/liked.service';
import { Account } from 'app/core/user/account.model';

@Component({
  selector: 'app-reviewdetail',
  templateUrl: './reviewdetail.component.html',
  styleUrls: ['./reviewdetail.component.scss']
})
export class ReviewdetailComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  id: any;
  detailReview: IReview;
  currentAccount: Account;
  currentUser: IUser;
  liked = false;
  likedReview: LikedReview;
  constructor(
    private reviewservice: ReviewService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private accountService: AccountService,
    private userService: UserService,
    private likedService: LikedService
  ) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.detailReview = res.detailNew;
      // eslint-disable-next-line
      console.log('sdsdasdasd: ', this.detailReview);
      this.accountService.identity().subscribe((account: Account) => {
        this.currentAccount = account;
        this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
          this.currentUser = userAuthen;
          this.likedService.checkStatusReview(this.currentUser.id, this.detailReview.id).subscribe(review => {
            this.likedReview = review.body;
            this.liked = this.likedReview.status;
          });
        });
      });
    });
  }
  checkLike(reviewID) {
    this.likedService.checkLikedReview(this.currentUser.id, reviewID).subscribe(res => {
      this.likedReview = res.body;
      this.liked = this.likedReview.status;
    });
  }
}
