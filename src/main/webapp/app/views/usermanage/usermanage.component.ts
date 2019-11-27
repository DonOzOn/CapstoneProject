import { Component, OnInit } from '@angular/core';
import { Router, NavigationStart, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-usermanage',
  templateUrl: './usermanage.component.html',
  styleUrls: ['./usermanage.component.scss']
})
export class UsermanageComponent implements OnInit {
  showLoadingIndicator = true;
  constructor(private router: Router) {
    this.ngcheckEvents();
  }

  ngOnInit() {}
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
