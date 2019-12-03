import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReviewComponent } from './review.component';
import { ListreviewComponent } from './listreview/listreview.component';
import { ReviewpageComponent } from './reviewpage/reviewpage.component';
import { ReviewdetailComponent } from './reviewdetail/reviewdetail.component';

const routes: Routes = [
  {
    path: '',
    component: ReviewComponent,
    data: {
      title: 'Review'
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
        path: 'reviewdetail',
        component: ReviewdetailComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReviewRoutingModule {}
