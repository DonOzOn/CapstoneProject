import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FlickityModule } from 'ngx-flickity';
import { HomeRoutingModule } from './home-routing.module';

import { NgModule } from '@angular/core';
import { HomeComponent } from '../home/home.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { CommonModule } from '@angular/common';
import { OwlModule } from 'ngx-owl-carousel';

@NgModule({
  declarations: [HomeComponent],
  imports: [
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatListModule,
    CommonModule,
    HomeRoutingModule,
    FlickityModule,
    MDBBootstrapModule.forRoot(),
    OwlModule
  ],
  providers: [],
  exports: [HomeComponent]
})
export class HomeModule {}
