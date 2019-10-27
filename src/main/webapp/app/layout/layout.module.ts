import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FooterComponent } from './footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductdetailComponent } from 'app/views/productdetail/productdetail.component';
import { ProductModule } from 'app/views/productdetail/productdetail.module';
import { P403Component } from './error/403.component';
import { P404Component } from './error/404.component';
import { P500Component } from './error/500.component';

const routes: Routes = [{ path: 'product', component: ProductdetailComponent }];

@NgModule({
  declarations: [HeaderComponent, FooterComponent,P403Component,P404Component,P500Component],
  imports: [ NgbModule, CommonModule, ProductModule, MDBBootstrapModule.forRoot(), RouterModule.forRoot(routes)],
  providers: [],
  exports: [HeaderComponent, FooterComponent]
})
export class LayoutModule {}
