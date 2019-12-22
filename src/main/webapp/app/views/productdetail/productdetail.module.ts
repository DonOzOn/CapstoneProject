import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FlickityModule } from 'ngx-flickity';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwlModule } from 'ngx-owl-carousel';
import { ProductdetailComponent } from './productdetail.component';
import { ProductRoutingModule } from './productdetail-routing.module';
import { GalleriaModule } from 'primeng/galleria';
import { ReactiveFormsModule } from '@angular/forms';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { MatTooltipModule } from '@angular/material/tooltip';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';
import { TooltipModule } from 'primeng/tooltip';

@NgModule({
  declarations: [ProductdetailComponent],
  imports: [
    CommonModule,
    ProductRoutingModule,
    FlickityModule,
    MDBBootstrapModule.forRoot(),
    OwlModule,
    GalleriaModule,
    ReactiveFormsModule,
    MessagesModule,
    MessageModule,
    MatTooltipModule,
    ToastModule,
    RealestatebrokerageSharedModule,
    TooltipModule
  ],
  providers: [],
  exports: [ProductdetailComponent]
})
export class ProductModule {}
