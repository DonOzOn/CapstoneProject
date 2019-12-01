import { Component, OnInit } from '@angular/core';
import { Ng7DynamicBreadcrumbService } from 'ng7-dynamic-breadcrumb';
import { LoginService } from 'app/core/login/login.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  /**
   * Breadcrumb config of admin component
   */
  breadcrumbConfig: object = {
    bgColor: 'white',
    fontSize: '18px',
    fontColor: '#0275d8',
    lastLinkColor: 'black',
    symbol: ' ▶ '
  };
  constructor(
    private ng7DynamicBreadcrumbService: Ng7DynamicBreadcrumbService,
    private router: Router,
    private loginService: LoginService
  ) {}
  ngOnInit() {
    const breadcrumb = { customText: 'This is Custom Text', dynamicText: 'Level 2 ' };
    this.ng7DynamicBreadcrumbService.updateBreadcrumbLabels(breadcrumb);
  }
  logout() {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }
}
