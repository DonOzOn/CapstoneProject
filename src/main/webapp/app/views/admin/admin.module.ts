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
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { DataViewModule } from 'primeng/dataview';
import { DataGridModule } from 'primeng/components/datagrid/datagrid';
import { PanelModule } from 'primeng/components/panel/panel';
import { TabViewModule } from 'primeng/components/tabview/tabview';
import { CodeHighlighterModule } from 'primeng/components/codehighlighter/codehighlighter';
import { NgSelectModule } from '@ng-select/ng-select';
import { CalendarModule } from 'primeng/calendar';
import { FileUploadModule } from 'primeng/fileupload';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { HttpClientModule } from '@angular/common/http';
import { SplitButtonModule } from 'primeng/splitbutton';
import { EditorModule } from 'primeng/editor';
import { DropdownModule } from 'primeng/dropdown';
import { CheckboxModule } from 'primeng/checkbox';
import { Ng7DynamicBreadcrumbModule } from 'ng7-dynamic-breadcrumb';
import { ManageNewsComponent } from './manage-new/manage-news';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { ManagereAllReviewpostComponent } from './manage-all-reviewpost/manage-all-reviewpost.component';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';
import { AdminNotificationComponent } from './admin-notification/admin-notification';

@NgModule({
  declarations: [
    AdminComponent,
    ManageAllProductpostComponent,
    ManageUserComponent,
    ManageNewsComponent,
    ManagereAllReviewpostComponent,
    AdminNotificationComponent
  ],
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
    FormsModule,
    InputTextModule,
    FormsModule,
    ReactiveFormsModule,
    DropdownModule,
    ButtonModule,
    DataViewModule,
    DataGridModule,
    PanelModule,
    DialogModule,
    TabViewModule,
    CodeHighlighterModule,
    NgSelectModule,
    SelectButtonModule,
    CalendarModule,
    FileUploadModule,
    ConfirmDialogModule,
    MessagesModule,
    MessageModule,
    EditorModule,
    HttpClientModule,
    SplitButtonModule,
    CheckboxModule,
    Ng7DynamicBreadcrumbModule,
    InputTextareaModule,
    RealestatebrokerageSharedModule
  ],
  providers: [],
  exports: [
    AdminComponent,
    ManageAllProductpostComponent,
    ManageUserComponent,
    ManageNewsComponent,
    ManagereAllReviewpostComponent,
    AdminNotificationComponent
  ]
})
export class AdminModule {}
