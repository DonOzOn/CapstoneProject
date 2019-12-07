import { Router } from '@angular/router';
import { LoginService } from './../../core/login/login.service';
import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Subscription } from 'rxjs';
import { AccountService } from 'app/core/auth/account.service';
import { LoginModalService } from 'app/core/login/login-modal.service';
import { JhiEventManager } from 'ng-jhipster';
import { Account } from 'app/core/user/account.model';
import { SERVER_API_URL } from 'app/app.constants';
import { NotificationService } from 'app/core/notification/notification.service';
import { HttpResponse } from '@angular/common/http';
import { INotification } from 'app/core/notification/notification.model';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
let self: any;
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  account: Account;
  pageSize = 20;
  totalRecords: number;
  authSubscription: Subscription;
  modalRef: NgbModalRef;
  isShowDropdown = false;
  isShowCart = false;
  isShowMenu = false;
  num: number;
  notis: INotification[];
  window: any;
  currentAccount: Account;
  currentUser: IUser;
  constructor(
    private loginService: LoginService,
    private accountService: AccountService,
    private loginModalService: LoginModalService,
    private eventManager: JhiEventManager,
    private router: Router,
    private notiService: NotificationService,
    private userService: UserService
  ) {}
  ngOnInit() {
    this.accountService.identity().subscribe((account: Account) => {
      this.account = account;
      this.userService.find(this.account.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
        debounceTime(200);
        distinctUntilChanged();
        this.fetch();
      });
    });
    self = this;
    this.window = window;
    const messageRecieved = e => {
      this.fetch();
    };
    this.window.addEventListener('messageRecieve', messageRecieved);
    if (this.accountService.isAuthenticated() === true) {
      this.window.window.requestPermission();
    }
    this.registerAuthenticationSuccess();
  }
  registerAuthenticationSuccess() {
    this.authSubscription = this.eventManager.subscribe('authenticationSuccess', message => {
      this.accountService.identity().subscribe(account => {
        this.account = account;
      });
    });
  }

  fetch(page = 0, sort?) {
    this.notiService
      .getListNotiByStatus({ userid: this.currentUser.id, page, size: this.pageSize, sort })
      .pipe()
      .subscribe(
        (res: HttpResponse<INotification[]>) => this.onSuccess(res.body, res.headers),
        (res: HttpResponse<any>) => this.onError(res.body)
      );
  }

  private onSuccess(data, headers) {
    this.totalRecords = headers.get('X-Total-Count');
    this.notis = data;
    this.num = this.notis.length;
  }
  private onError(error) {
    // eslint-disable-next-line
    console.log('error: ', error);
  }
  isAuthenticated() {
    return this.accountService.isAuthenticated();
  }

  login() {
    this.modalRef = this.loginModalService.open();
  }

  // tslint:disable-next-line:use-life-cycle-interface
  ngOnDestroy() {
    if (this.authSubscription) {
      this.eventManager.destroy(this.authSubscription);
    }
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }
  requestChangePassword() {
    this.router.navigate(['/account/password']);
  }

  showMenu() {
    this.isShowMenu = !this.isShowMenu;
  }
  showDropdown() {
    this.isShowDropdown = !this.isShowDropdown;
  }
  showCart() {
    this.isShowCart = !this.isShowCart;
  }
  seen(id: any) {
    this.notiService.delete(id).subscribe(res => {
      // eslint-disable-next-line
      console.log('delete : ', res.body);
      this.fetch();
    });
  }
}
