import { NgModule, Injectable } from '@angular/core';
import { Routes, RouterModule, Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { ReviewComponent } from './review.component';
import { ListreviewComponent } from './listreview/listreview.component';
import { ReviewpageComponent } from './reviewpage/reviewpage.component';
import { ReviewdetailComponent } from './reviewdetail/reviewdetail.component';
import { ReviewService } from 'app/core/review/review.service';
@Injectable({ providedIn: 'root' })
export class DetailReviewResolve implements Resolve<any> {
  detaireview: any;
  constructor(private reviewservice: ReviewService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params.id ? route.params.id : null;
    if (id) {
      // eslint-disable-next-line
      console.log('idddd: ', id);
      // eslint-disable-next-line
      console.log('after delete uploadedFiles: ', this.reviewservice.find(id));
      return this.reviewservice.find(id);
    }
    return new this.detaireview();
  }
}
const routes: Routes = [
  {
    path: '',
    component: ReviewComponent,
    data: {
      title: 'Đánh giá'
    },
    children: [
      {
        path: '',
        component: ReviewpageComponent
      },
      {
        path: 'listreview',
        component: ListreviewComponent
      },
      {
        path: ':id/detail',
        component: ReviewdetailComponent,
        resolve: {
          detailNew: DetailReviewResolve
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReviewRoutingModule {}
