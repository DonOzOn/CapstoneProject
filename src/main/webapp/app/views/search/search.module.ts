import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CollapseModule, WavesModule } from 'angular-bootstrap-md';

import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { SearchRoutingModule } from './search-routing.module';
import { SearchComponent } from './search.component';
import { IconsModule } from 'angular-bootstrap-md';

@NgModule({
  declarations: [SearchComponent],
  imports: [
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatListModule,
    CommonModule,
    SearchRoutingModule,
    CollapseModule.forRoot(),
    WavesModule.forRoot(),
    IconsModule
  ],
  providers: [],
  exports: [SearchComponent]
})
export class SearchModule {}
