import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FooterComponent } from './footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductdetailComponent } from 'app/views/productdetail/productdetail.component';
import { LoginModule } from 'app/views/login/login.module';
import { ProductModule } from 'app/views/productdetail/productdetail.module';
const routes: Routes = [{ path: 'product', component: ProductdetailComponent }];

@NgModule({
  declarations: [HeaderComponent, FooterComponent],
  imports: [LoginModule, NgbModule, CommonModule, ProductModule, MDBBootstrapModule.forRoot(), RouterModule.forRoot(routes)],
  providers: [],
  exports: [HeaderComponent, FooterComponent]
})
export class LayoutModule {}
