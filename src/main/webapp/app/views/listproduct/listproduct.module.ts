import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { ListproductRoutingModule } from './listproduct-routing.module';
import { IconsModule, ButtonsModule } from 'angular-bootstrap-md';
import { ListproductComponent } from './listproduct.component';

@NgModule({
  declarations: [ListproductComponent],
  imports: [CommonModule, ListproductRoutingModule, IconsModule, ButtonsModule, MDBBootstrapModule.forRoot()],
  providers: [],
  exports: [ListproductComponent]
})
export class ListproductModule {}
