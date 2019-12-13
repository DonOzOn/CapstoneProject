import { Component, OnInit, Inject } from '@angular/core';
import { trigger, state, transition, style, animate } from '@angular/animations';
import { DOCUMENT } from '@angular/common';
import { NavigationStart, NavigationEnd, Router, NavigationCancel, NavigationError } from '@angular/router';
import { FacebookService, InitParams } from 'ngx-facebook';
import { MessageService } from 'primeng/api';
import { AccountService } from './core/auth/account.service';
import { Account } from './core/user/account.model';
import { IUser } from './core/user/user.model';
import { FormControl } from '@angular/forms';
let self: any;
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
  window: any;
  name = new FormControl('');
  currentAccount: Account;
  constructor(
    @Inject(DOCUMENT) document,
    private router: Router,
    private facebookService: FacebookService,
    private accountService: AccountService,
    private messageService: MessageService
  ) {
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
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
    });
    self = this;
    this.window = window;
    this.window.addEventListener('saveToken', this.saveUserToken);
    const messageRecieve = e => {
      // eslint-disable-next-line
      console.log('don123: ', e.detail);
      this.messageService.add({ severity: 'info', summary: e.detail.notification.title, detail: e.detail.notification.body });
    };
    this.window.addEventListener('messageRecieve', messageRecieve);
    if (this.accountService.isAuthenticated() === true) {
      this.window.window.requestPermission();
    }
  }

  messageRecieved(e) {
    // eslint-disable-next-line
    console.log('don123: ', e.detail);
    this.name = e.detail;
  }
  saveUserToken(e) {
    self.userService.find(self.currentAccount.login).subscribe((userAuthen: IUser) => {
      self.currentUser = userAuthen;
      self.currentUser.token = e.detail;
      self.userService.update(self.currentUser).subscribe(res => {
        // eslint-disable-next-line
        console.log('update..fdfdf: ', res.body);
      });
      // eslint-disable-next-line
      console.log('save token: ', e.detail);
    });

    // eslint-disable-next-line
    console.log('e.detail: ', e.detail);
  }

  initFacebookService(): void {
    const initParams: InitParams = { xfbml: true, version: 'v3.2' };
    this.facebookService.init(initParams);
  }
}
