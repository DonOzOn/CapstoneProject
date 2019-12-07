import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { FengShuiRoutingModule } from './fengshui-routing.module';
import { IconsModule, ButtonsModule } from 'angular-bootstrap-md';
import { FengshuiComponent } from './fengshui.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';

@NgModule({
  declarations: [FengshuiComponent],
  imports: [
    CommonModule,
    FengShuiRoutingModule,
    IconsModule,
    ButtonsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    RealestatebrokerageSharedModule
  ]
})
export class FengShuiModule {}
