import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AdminRoutingModule } from './admin-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ManageAllProductpostComponent } from './manage-allproductpost/manage-allproductpost';
import { ManageUserComponent } from './manage-user/manage-user.component';
import { TableModule } from 'primeng/table';
import { DialogModule } from 'primeng/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SelectButtonModule } from 'primeng/selectbutton';

@NgModule({
  declarations: [AdminComponent, ManageAllProductpostComponent, ManageUserComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MDBBootstrapModule.forRoot(),
    ToastModule,
    ConfirmDialogModule,
    TableModule,
    DialogModule,
    FormsModule,
    SelectButtonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  exports: [AdminComponent, ManageAllProductpostComponent, ManageUserComponent]
})
export class AdminModule {}
