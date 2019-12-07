import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FlickityModule } from 'ngx-flickity';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwlModule } from 'ngx-owl-carousel';
import { NewsComponent } from './news.component';
import { NewsRoutingModule } from './news-routing.module';
import { NewsdetailComponent } from './newsdetail/newsdetail.component';
import { NewspageComponent } from './newspage/newspage.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';

@NgModule({
  declarations: [NewsComponent, NewsdetailComponent, NewspageComponent],
  imports: [
    CommonModule,
    NewsRoutingModule,
    NgxPaginationModule,
    FlickityModule,
    MDBBootstrapModule.forRoot(),
    OwlModule,
    RealestatebrokerageSharedModule
  ],
  providers: [],
  exports: [NewsComponent]
})
export class NewsModule {}
