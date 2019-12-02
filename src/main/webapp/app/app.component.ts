import { Component, OnInit, Inject } from '@angular/core';
import { trigger, state, transition, style, animate } from '@angular/animations';
import { DOCUMENT } from '@angular/common';
import { NavigationStart, NavigationEnd, Router, NavigationCancel, NavigationError } from '@angular/router';
import { FacebookService, InitParams } from 'ngx-facebook';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  animations: [
    trigger('fade', [state('void', style({ opacity: 0 })), transition(':enter', [animate(300)]), transition(':leave', [animate(500)])])
  ],
  providers: [MessageService]
})
export class AppComponent implements OnInit {
  title = 'RealEstateBrokerageCient';
  showLoadingIndicator = true;
  constructor(@Inject(DOCUMENT) document, private router: Router, private facebookService: FacebookService) {
    this.router.events.subscribe(event => {
      switch (true) {
        case event instanceof NavigationStart:
          this.showLoadingIndicator = true;
          break;
        case event instanceof NavigationEnd:
          this.showLoadingIndicator = false;
          break;
        case event instanceof NavigationCancel:
          this.showLoadingIndicator = false;
          break;
        case event instanceof NavigationError:
          this.showLoadingIndicator = false;
          break;
        default:
          break;
      }
    });
  }

  ngOnInit() {
    this.initFacebookService();
    this.router.events.subscribe(evt => {
      if (!(evt instanceof NavigationEnd)) {
        return;
      }
      window.scrollTo(0, 0);
    });
  }

  initFacebookService(): void {
    const initParams: InitParams = { xfbml: true, version: 'v3.2' };
    this.facebookService.init(initParams);
  }
}
