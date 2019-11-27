import { Component, OnInit, ViewChild } from '@angular/core';
import { SelectItem, ConfirmationService, MessageService, LazyLoadEvent, FilterUtils } from 'primeng/api';
import { Validators, FormBuilder } from '@angular/forms';
import { IUser } from 'app/core/user/user.model';
import { JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { HttpResponse } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Table } from 'primeng/table';

export interface Car {
  vin: any;
  year: any;
  brand: any;
  color: any;
}

@Component({
  selector: 'app-manageuser',
  templateUrl: './manage-user.component.html',
  styleUrls: ['./manage-user.scss'],
  providers: [ConfirmationService, MessageService]
})
export class ManageUserComponent implements OnInit {
  @ViewChild('usersTable', { static: false }) usersTable: Table;
  /*  Item select button  */
  selectedType: string;
  types: SelectItem[];
  selectedUtility: string[] = [];
  isUploadedFile;
  false;
  text1 = '<div>Hello!</div><div>Chào mừng tới BDS</div><div><br></div>';
  formAddress = this.fb.group({
    address: [null, Validators.required],
    provinceCode: [null, Validators.required],
    districtCode: [null, Validators.required],
    wardCode: [null, Validators.required]
  });
  /*  List provinces, district, ward, direction */

  currentAccount: IUser;
  users: IUser[];

  pageSize = 10;

  show = false;

  displayDialog: boolean;

  totalRecords: number;

  loading: boolean;

  user: IUser = {};

  selectedUser: IUser;

  newUser: boolean;

  cols: any[];

  constructor(
    private fb: FormBuilder,
    // private elementRef: ElementRef,
    // private renderer: Renderer,
    private confirmationService: ConfirmationService,
    private alertService: JhiAlertService,
    private router: Router,
    private accountService: AccountService,
    private userService: UserService,
    private messageService: MessageService
  ) {
    this.types = [{ label: 'ADMIN', value: 'ROLE_ADMIN' }, { label: 'USER', value: 'ROLE_USER' }];
  }

  ngOnInit() {
    this.cols = [
      { field: 'login', header: 'Tài khoản' },
      { field: 'email', header: 'Email' },
      { field: 'gender', header: 'Giới tính' },
      { field: 'phone', header: 'Số điện thoại' },
      { field: 'activated', header: 'Trạng thái' }
    ];
    this.accountService.identity().subscribe(account => {
      this.currentAccount = account;
      // this.name.valueChanges
      //     .pipe(
      //         debounceTime(200),
      //         distinctUntilChanged(),
      //         tap(() => (this.loading = true)),
      //         tap(() => this.fetch()),
      //         tap(() => this.usersTable.reset())
      //     )
      //     .subscribe();
    });
    FilterUtils['custom'] = (value, filter): boolean => {
      if (filter === undefined || filter === null || filter.trim() === '') {
        return true;
      }

      if (value === undefined || value === null) {
        return false;
      }
      // eslint-disable-next-line
      return parseInt(filter) > value;
    };
    this.loading = true;
  }

  save(user: IUser) {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn sửa người dùng này không không ?',
      icon: 'fa fa-question-circle',
      key: 'cf',
      accept: () => {
        user.authorities = [this.selectedType];
        this.userService.updateActive(user).subscribe(respone => {
          if (respone.status === 200) {
            this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã cập nhật thành công !' });
            this.displayDialog = false;
            this.fetch();
          } else {
            this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Cập nhật thất bại!' });
          }
        });
      }
    });
  }

  changeRole(event) {
    this.selectedType = event.value;
  }

  selectUserWithButton(user: IUser) {
    this.selectedUser = user;
    // eslint-disable-next-line
    console.log('user select : ', this.selectedUser);
    if (this.selectedUser.authorities[0] === 'ROLE_ADMIN') {
      this.selectedType = this.types[0].value;
    } else {
      this.selectedType = this.types[1].value;
    }
    this.displayDialog = true;
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

  fetch(page = 0, sort?) {
    this.userService
      .query({ page, size: this.pageSize, sort })
      .pipe(tap(() => (this.loading = true)))
      .subscribe((res: HttpResponse<IUser[]>) => this.onSuccess(res.body, res.headers), (res: HttpResponse<any>) => this.onError(res.body));
  }

  onRowSelect(event) {
    this.newUser = false;
    this.user = this.cloneUser(event.data);
    this.displayDialog = true;
  }

  cloneUser(c: IUser): IUser {
    // eslint-disable-next-line
    let user = {};
    // eslint-disable-next-line
    for (let prop in c) {
      user[prop] = c[prop];
    }
    return user;
  }

  confirmOnOFF(user: IUser) {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn ' + (user.activated ? 'tắt' : 'bật') + 'người dùng này khônng?',
      key: user.activated ? 'off' : 'on',
      accept: () => {
        this.setActive(user, !user.activated);
      }
    });
  }
  setActive(user, isActivated) {
    user.activated = isActivated;
    this.userService.updateActive(user).subscribe(response => {
      if (response.status === 200) {
        this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã cập nhật thành công !' });
        this.fetch();
      } else {
        this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Cập nhật thất bại!' });
      }
    });
  }

  private onSuccess(data, headers) {
    this.loading = false;
    this.totalRecords = headers.get('X-Total-Count');
    this.users = data;
  }
  private onError(error) {
    this.loading = false;
    this.alertService.error(error.error, error.message, null);
  }
}
