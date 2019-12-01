import { Component, OnInit } from '@angular/core';
import { Router, NavigationStart, NavigationEnd } from '@angular/router';
import { Ng7DynamicBreadcrumbService } from 'ng7-dynamic-breadcrumb';
import { LoginService } from 'app/core/login/login.service';

@Component({
  selector: 'app-usermanage',
  templateUrl: './usermanage.component.html',
  styleUrls: ['./usermanage.component.scss']
})
export class UsermanageComponent implements OnInit {
  showLoadingIndicator = true;
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
    private router: Router,
    private loginService: LoginService,
    private ng7DynamicBreadcrumbService: Ng7DynamicBreadcrumbService
  ) {
    this.ngcheckEvents();
  }

  ngOnInit() {
    const breadcrumb = { customText: 'This is Custom Text', dynamicText: 'Level 2 ' };
    this.ng7DynamicBreadcrumbService.updateBreadcrumbLabels(breadcrumb);
  }
  logout() {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }
  ngcheckEvents() {
    this.router.events.subscribe(event => {
      switch (true) {
        case event instanceof NavigationStart:
          this.showLoadingIndicator = true;
          break;
        case event instanceof NavigationEnd:
          this.showLoadingIndicator = false;
          break;
        default:
          break;
      }
    });
  }
}
