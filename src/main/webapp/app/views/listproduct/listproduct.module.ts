import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MDBBootstrapModule, WavesModule, CollapseModule, ModalModule } from 'angular-bootstrap-md';
import { ListproductRoutingModule } from './listproduct-routing.module';
import { IconsModule, ButtonsModule } from 'angular-bootstrap-md';
import { ListproductComponent } from './listproduct.component';
import { OrderModule } from 'ngx-order-pipe';
import { ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng7DynamicBreadcrumbModule } from 'ng7-dynamic-breadcrumb';
import { MatSelectModule } from '@angular/material/select';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';
import { ToastModule } from 'primeng/toast';
import { MessageModule } from 'primeng/message';
import { MessagesModule } from 'primeng/messages';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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
    MDBBootstrapModule.forRoot(),
    CollapseModule.forRoot(),
    WavesModule.forRoot(),
    Ng7DynamicBreadcrumbModule,
    MatSelectModule,
    RealestatebrokerageSharedModule,
    MessagesModule,
    MessageModule,
    ToastModule,
    ModalModule,
    NgbModule
  ],
  providers: [],
  exports: [ListproductComponent]
})
export class ListproductModule {}
