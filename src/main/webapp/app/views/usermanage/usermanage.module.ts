import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FlickityModule } from 'ngx-flickity';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwlModule } from 'ngx-owl-carousel';
import { UsermanageComponent } from './usermanage.component';
import { UsermanageRoutingModule } from './usermanage-routing.module';
import { ProfileComponent } from './profile/profile.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { ManageproductpostComponent } from './manageproductpost/manageproductpost.component';
import { DataViewModule } from 'primeng/dataview';
import { DataGridModule } from 'primeng/components/datagrid/datagrid';
import { PanelModule } from 'primeng/components/panel/panel';
import { DialogModule } from 'primeng/components/dialog/dialog';
import { TabViewModule } from 'primeng/components/tabview/tabview';
import { CodeHighlighterModule } from 'primeng/components/codehighlighter/codehighlighter';
import { ManagereviewpostComponent } from './managereviewpost/managereviewpost.component';
import { NotificationComponent } from './notification/notification.component';
import { NgSelectModule } from '@ng-select/ng-select';
import {SelectButtonModule} from 'primeng/selectbutton';
import {CalendarModule} from 'primeng/calendar';
import {FileUploadModule} from 'primeng/fileupload';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';

@NgModule({
  declarations: [UsermanageComponent, ProfileComponent, ManageproductpostComponent, ManagereviewpostComponent, NotificationComponent],
  imports: [
    CommonModule,
    UsermanageRoutingModule,
    FlickityModule,
    MDBBootstrapModule.forRoot(),
    OwlModule,
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
    ToastModule
  ],
  providers: [],
  exports: [UsermanageComponent]
})
export class UsermanageModule {}
