import { Component, OnInit } from '@angular/core';
import { NotificationService } from 'app/core/notification/notification.service';
import { INotification } from 'app/core/notification/notification.model';
import { LazyLoadEvent } from 'primeng/api';
import { HttpResponse } from '@angular/common/http';
import { JhiAlertService } from 'ng-jhipster';
import { tap, debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';
import { SERVER_API_URL } from 'app/app.constants';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss']
})
export class NotificationComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  pageSize = 20;
  totalRecords: number;
  loading: boolean;
  notis: INotification[];
  currentAccount: Account;
  currentUser: IUser;
  checked: false;
  /* pagination */
  public directionLinks = true;
  public autoHide = false;
  public responsive = true;
  public maxSize = 5;
  listPagination: any[] = [];
  config: any;
  count: any;
  public labels: any = {
    previousLabel: 'Trước',
    nextLabel: 'Sau'
  };
  constructor(
    private notificationService: NotificationService,
    private alertService: JhiAlertService,
    private accountService: AccountService,
    private userService: UserService,
    private router: Router
  ) {
    for (let i = 0; i < this.count; i++) {
      this.listPagination.push({
        id: i + 1,
        value: 'items number' + (i + 1)
      });
    }
    this.config = {
      itemsPerPage: 5,
      currentPage: 1,
      totalItems: this.count
    };
  }

  /*  get total page in pagination*/
  getTotalPage() {
    this.notificationService.getListNoti().subscribe(res => {
      this.count = res.body.length;
      return this.count;
    });
  }
  pageChanged(event) {
    this.config.currentPage = event;
  }

  ngOnInit() {
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
        debounceTime(200);
        distinctUntilChanged();
        this.loading = true;
        this.fetch();
      });
    });
    this.notificationService.getListNoti();
  }
  fetch(page = 0, sort?) {
    this.notificationService
      .getListNoti({ userid: this.currentUser.id, page, size: this.pageSize, sort })
      .pipe(tap(() => (this.loading = true)))
      .subscribe(
        (res: HttpResponse<INotification[]>) => this.onSuccess(res.body, res.headers),
        (res: HttpResponse<any>) => this.onError(res.body)
      );
  }
  loadUserLazy(event: LazyLoadEvent) {
    this.loading = true;
    let sort = '';
    setTimeout(() => {
      if (event.sortField != null) {
        sort = event.sortField + ',';
        sort += event.sortOrder > 0 ? 'asc' : 'desc';
      }
      this.fetch(event.first / event.rows, [sort]);
      this.loading = false;
    }, 500);
  }
  private onSuccess(data, headers) {
    this.loading = false;
    this.totalRecords = headers.get('X-Total-Count');
    this.notis = data;
  }
  private onError(error) {
    this.loading = false;
    this.alertService.error(error.error, error.message, null);
  }
  redirectTo(uri: string) {
    this.router.navigateByUrl('/home', { skipLocationChange: true }).then(() => this.router.navigate([uri]));
  }

  seen(id: any) {
    this.notificationService.delete(id).subscribe(res => {
      // eslint-disable-next-line
      console.log('delete : ', res.body);
      this.fetch();
      this.redirectTo('/notification');
    });
  }
}
