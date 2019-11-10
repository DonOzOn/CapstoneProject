import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { ListproductRoutingModule } from './listproduct-routing.module';
import { IconsModule, ButtonsModule } from 'angular-bootstrap-md';
import { ListproductComponent } from './listproduct.component';
import { OrderModule } from 'ngx-order-pipe';
import { ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [ListproductComponent],
  imports: [
    CommonModule,
    ListproductRoutingModule,
    IconsModule,
    OrderModule,
    ButtonsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  exports: [ListproductComponent]
})
export class ListproductModule {}
