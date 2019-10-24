import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { FengShuiRoutingModule } from './fengshui-routing.module';
import { IconsModule, ButtonsModule } from 'angular-bootstrap-md';
import { FengshuiComponent } from './fengshui.component';

@NgModule({
  declarations: [FengshuiComponent],
  imports: [CommonModule, FengShuiRoutingModule, IconsModule, ButtonsModule, MDBBootstrapModule.forRoot()]
})
export class FengShuiModule {}
