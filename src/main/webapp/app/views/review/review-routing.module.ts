import { NgModule, Injectable } from '@angular/core';
import { Routes, RouterModule, Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { ReviewComponent } from './review.component';
import { ListreviewComponent } from './listreview/listreview.component';
import { ReviewpageComponent } from './reviewpage/reviewpage.component';
import { ReviewdetailComponent } from './reviewdetail/reviewdetail.component';
import { ReviewService } from 'app/core/review/review.service';
import { GalleryComponent } from './gallery/gallery.component';
import { ContactComponent } from './contact/contact.component';
import { NotificationreviewComponent } from './notificationreview/notificationreview.component';
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

@Injectable({ providedIn: 'root' })
export class FullTextSearchResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: ReviewService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const textSearch = route.params.textSearch ? route.params.textSearch : null;
    if (textSearch) {
      return this.service.fullTextSearch(textSearch);
    }
    return new this.detainew();
  }
}
@Injectable({ providedIn: 'root' })
export class AllReviewResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: ReviewService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.service.getListReview();
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
        component: ListreviewComponent,
        resolve: {
          typeSearch: AllReviewResolve
        }
      },
      {
        path: ':id/detail',
        component: ReviewdetailComponent,
        resolve: {
          detailNew: DetailReviewResolve
        }
      },

      {
        path: 'searchReview/:textSearch',
        component: ListreviewComponent,
        resolve: {
          typeSearch: FullTextSearchResolve
        }
      },
      {
        path: 'gallery',
        component: GalleryComponent
      },
      {
        path: 'contact',
        component: ContactComponent
      },
      {
        path: 'notificationreview',
        component: NotificationreviewComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReviewRoutingModule {}
