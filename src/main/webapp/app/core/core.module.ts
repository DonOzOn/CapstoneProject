import { NewsService } from './service/news.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CarService } from './service/car.service';

@NgModule({
  declarations: [],
  imports: [BrowserModule],
  providers: [NewsService, CarService],
  bootstrap: []
})
export class CoreModule {}
