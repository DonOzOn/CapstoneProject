import { PostproductComponent } from './postproduct.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FlickityModule } from 'ngx-flickity';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwlModule } from 'ngx-owl-carousel';
import { PostproductRoutingModule } from './postproduct-routing.module';
import { InputTextModule } from 'primeng/inputtext';
import { ReactiveFormsModule } from '@angular/forms';
import { SelectButtonModule } from 'primeng/selectbutton';
import { FormsModule } from '@angular/forms';
import { DropdownModule } from 'primeng/dropdown';
import { EditorModule } from 'primeng/editor';
import { ButtonModule } from 'primeng/button';
import { FileUploadModule } from 'primeng/fileupload';
import { HttpClientModule } from '@angular/common/http';
import { CodeHighlighterModule } from 'primeng/components/codehighlighter/codehighlighter';
import { SplitButtonModule } from 'primeng/splitbutton';
import { CheckboxModule } from 'primeng/checkbox';

@NgModule({
  declarations: [PostproductComponent],
  imports: [
    CommonModule,
    PostproductRoutingModule,
    FlickityModule,
    MDBBootstrapModule.forRoot(),
    OwlModule,
    InputTextModule,
    ReactiveFormsModule,
    FormsModule,
    SelectButtonModule,
    DropdownModule,
    EditorModule,
    ButtonModule,
    FileUploadModule,
    HttpClientModule,
    CodeHighlighterModule,
    SplitButtonModule,
    CheckboxModule
  ],
  providers: [],
  exports: [PostproductComponent]
})
export class PostProductModule {}
