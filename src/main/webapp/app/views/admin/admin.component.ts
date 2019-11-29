import { Component, OnInit } from '@angular/core';
import { Ng7DynamicBreadcrumbService } from 'ng7-dynamic-breadcrumb';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  breadcrumbConfig: object = {
    bgColor: 'white',
    fontSize: '18px',
    fontColor: '#0275d8',
    lastLinkColor: 'black',
    symbol: ' ▶ '
  };
  constructor(private ng7DynamicBreadcrumbService: Ng7DynamicBreadcrumbService) {}
  ngOnInit() {
    const breadcrumb = { customText: 'This is Custom Text', dynamicText: 'Level 2 ' };
    this.ng7DynamicBreadcrumbService.updateBreadcrumbLabels(breadcrumb);
  }
}
