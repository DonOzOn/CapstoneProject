import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FooterComponent } from './footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductdetailComponent } from 'app/views/productdetail/productdetail.component';
import { ProductModule } from 'app/views/productdetail/productdetail.module';
import { P403Component } from './error2/403.component';
import { P404Component } from './error2/404.component';
import { P500Component } from './error2/500.component';
import { TooltipModule } from 'primeng/tooltip';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';
import { GotoTopComponent } from './gotoTop/gotoTop.component';

const routes: Routes = [{ path: 'product', component: ProductdetailComponent }];

@NgModule({
  declarations: [HeaderComponent, FooterComponent, P403Component, P404Component, P500Component, GotoTopComponent],
  imports: [
    NgbModule,
    CommonModule,
    ProductModule,
    MDBBootstrapModule.forRoot(),
    RouterModule.forRoot(routes),
    TooltipModule,
    RealestatebrokerageSharedModule
  ],
  providers: [],
  exports: [HeaderComponent, FooterComponent, GotoTopComponent]
})
export class LayoutModule {}
