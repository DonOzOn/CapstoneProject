import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FlickityModule } from 'ngx-flickity';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwlModule } from 'ngx-owl-carousel';
import { LawComponent } from './law.component';
import { LawRoutingModule } from './law-routing.module';
import { LawsellComponent } from './lawsell/lawsell.component';
import { LawpageComponent } from './lawpage/lawpage.component';
import { LawrentComponent } from './lawrent/lawrent.component';
import { ContracformComponent } from './contracform/contracform.component';
import { AddresscontractComponent } from './addresscontract/addresscontract.component';
import { RealestatebrokerageSharedModule } from 'app/shared/shared.module';

@NgModule({
  declarations: [LawComponent, LawsellComponent, LawpageComponent, LawrentComponent, ContracformComponent, AddresscontractComponent],
  imports: [CommonModule, LawRoutingModule, FlickityModule, MDBBootstrapModule.forRoot(), OwlModule, RealestatebrokerageSharedModule],
  providers: [],
  exports: [LawComponent]
})
export class LawModule {}
