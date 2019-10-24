import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReviewRoutingModule } from './review-routing.module';
import { ReviewComponent } from './review.component';
import { ListreviewComponent } from './listreview/listreview.component';
import { ReviewpageComponent } from './reviewpage/reviewpage.component';

@NgModule({
  declarations: [ReviewComponent, ListreviewComponent, ReviewpageComponent],
  imports: [CommonModule, ReviewRoutingModule],
  providers: [],
  exports: [ReviewComponent]
})
export class ReviewModule {}
