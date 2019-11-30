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
import { CarouselModule } from 'primeng/carousel';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { TabViewModule } from 'primeng/components/tabview/tabview';
import { CodeHighlighterModule } from 'primeng/components/codehighlighter/codehighlighter';
import { ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

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
    OwlModule,
    CarouselModule,
    ButtonModule,
    ToastModule,
    TabViewModule,
    NgxPaginationModule,
    CodeHighlighterModule,
    ReactiveFormsModule
  ],
  providers: [],
  exports: [HomeComponent]
})
export class HomeModule {}
