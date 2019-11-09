import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FlickityModule } from 'ngx-flickity';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwlModule } from 'ngx-owl-carousel';
import { ProductdetailComponent } from './productdetail.component';
import { ProductRoutingModule } from './productdetail-routing.module';
import { GalleriaModule } from 'primeng/galleria';

@NgModule({
  declarations: [ProductdetailComponent],
  imports: [CommonModule, ProductRoutingModule, FlickityModule, MDBBootstrapModule.forRoot(), OwlModule, GalleriaModule],
  providers: [],
  exports: [ProductdetailComponent]
})
export class ProductModule {}
