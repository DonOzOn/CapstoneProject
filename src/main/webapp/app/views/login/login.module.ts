import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// tslint:disable-next-line: max-line-length
import {
  CollapseModule,
  WavesModule,
  TooltipModule,
  PopoverModule,
  ModalModule,
  ButtonsModule,
  MDBBootstrapModule
} from 'angular-bootstrap-md';
import { IconsModule } from 'angular-bootstrap-md';
import { LoginComponent } from './login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegisterComponent } from '../register/register.component';
import { RealestatebrokerageAccountModule } from '../account/account.module';
import { RealestatebrokerageSharedLibsModule } from 'app/shared/shared-libs.module';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';

@NgModule({
  declarations: [LoginComponent, RegisterComponent],
  imports: [
    CommonModule,
    CollapseModule.forRoot(),
    WavesModule.forRoot(),
    IconsModule,
    TooltipModule,
    PopoverModule,
    ButtonsModule,
    ModalModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    CommonModule,
    RealestatebrokerageSharedModule,
    RealestatebrokerageSharedLibsModule,
    RealestatebrokerageAccountModule
  ],
  providers: [],
  exports: [LoginComponent]
})
export class LoginModule {}
