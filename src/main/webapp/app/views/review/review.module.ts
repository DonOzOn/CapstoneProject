import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReviewRoutingModule } from './review-routing.module';
import { ReviewComponent } from './review.component';
import { ListreviewComponent } from './listreview/listreview.component';
import { ReviewpageComponent } from './reviewpage/reviewpage.component';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { FileUploadModule } from 'primeng/fileupload';
import { EditorModule } from 'primeng/editor';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ToastModule } from 'primeng/toast';
import { MessageModule } from 'primeng/message';
import { MessagesModule } from 'primeng/messages';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { SelectButtonModule } from 'primeng/selectbutton';
import { CodeHighlighterModule } from 'primeng/components/codehighlighter/codehighlighter';
import { SplitButtonModule } from 'primeng/splitbutton';
import { PanelModule } from 'primeng/components/panel/panel';
import { TabViewModule } from 'primeng/components/tabview/tabview';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ReviewdetailComponent } from './reviewdetail/reviewdetail.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { MatTooltipModule } from '@angular/material/tooltip';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';
import { GalleryComponent } from './gallery/gallery.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [ReviewComponent, ListreviewComponent, ReviewpageComponent, ReviewdetailComponent, GalleryComponent, ContactComponent],
  imports: [
    CommonModule,
    ReviewRoutingModule,
    ButtonModule,
    DialogModule,
    FileUploadModule,
    EditorModule,
    FormsModule,
    ReactiveFormsModule,
    MessagesModule,
    MessageModule,
    ToastModule,
    NgxPaginationModule,
    InputTextModule,
    InputTextareaModule,
    SelectButtonModule,
    CodeHighlighterModule,
    SplitButtonModule,
    PanelModule,
    TabViewModule,
    MatTooltipModule,
    ConfirmDialogModule,
    RealestatebrokerageSharedModule
  ],
  providers: [],
  exports: [ReviewComponent]
})
export class ReviewModule {}
