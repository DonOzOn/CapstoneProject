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

@NgModule({
  declarations: [ReviewComponent, ListreviewComponent, ReviewpageComponent],
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
    InputTextModule,
    InputTextareaModule,
    SelectButtonModule,
    CodeHighlighterModule,
    SplitButtonModule,
    PanelModule,
    TabViewModule,
    ConfirmDialogModule
  ],
  providers: [],
  exports: [ReviewComponent]
})
export class ReviewModule {}
