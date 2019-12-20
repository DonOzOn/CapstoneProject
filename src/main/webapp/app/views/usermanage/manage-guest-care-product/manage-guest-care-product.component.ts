import { Component, OnInit, ViewChild } from '@angular/core';
import { SelectItem, ConfirmationService, MessageService, LazyLoadEvent, FilterUtils } from 'primeng/api';
import { Validators, FormBuilder, FormControl } from '@angular/forms';
import { IUser } from 'app/core/user/user.model';
import { JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { HttpResponse } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Table } from 'primeng/table';
import { GuestCareProductService } from 'app/core/guest-care-product/guest-care-product.service';
import { IGuestCareProduct } from 'app/core/guest-care-product/guest-care-product.model';
import { Account } from 'app/core/user/account.model';

@Component({
  selector: 'app-manage-guest-care-product',
  templateUrl: './manage-guest-care-product.component.html',
  styleUrls: ['./manage-guest-care-product.scss'],
  providers: [ConfirmationService, MessageService]
})
export class ManageGuestCareComponent implements OnInit {
  @ViewChild('guestCare', { static: false }) guestCare: Table;
  /*  Item select button  */
  selectedType: string;
  types: SelectItem[];
  selectedUtility: string[] = [];
  userid = new FormControl('');
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

  currentAccount: Account;
  currentUser: IUser;
  guests: IGuestCareProduct[];

  pageSize = 10;

  show = false;

  displayDialog: boolean;

  totalRecords: number;

  loading: boolean;

  guestCares: IGuestCareProduct = {};

  selectedGuest: IGuestCareProduct;

  newGuest: boolean;

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
    private guestCareService: GuestCareProductService,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.cols = [
      { field: 'login', header: 'Tài khoản' },
      { field: 'email', header: 'Email' },
      { field: 'gender', header: 'Giới tính' },
      { field: 'phone', header: 'Số điện thoại' },
      { field: 'activated', header: 'Trạng thái' }
    ];
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
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
        this.userid = this.currentUser.id;
      });
    });
  }

  changeRole(event) {
    this.selectedType = event.value;
  }

  selectUserWithButton(guest: IGuestCareProduct) {
    this.selectedGuest = guest;
    // eslint-disable-next-line
    console.log('guest select : ', this.selectedGuest);
    this.displayDialog = true;
  }

  loadGuestLazy(event: LazyLoadEvent) {
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
    this.guestCareService
      .query({ userid: this.userid, page, size: this.pageSize, sort })
      .pipe(tap(() => (this.loading = true)))
      .subscribe((res: HttpResponse<IUser[]>) => this.onSuccess(res.body, res.headers), (res: HttpResponse<any>) => this.onError(res.body));
  }

  onRowSelect(event) {
    this.newGuest = false;
    this.guestCares = this.cloneGuest(event.data);
    this.displayDialog = true;
  }

  cloneGuest(c: IGuestCareProduct): IGuestCareProduct {
    // eslint-disable-next-line
    let guestCare = {};
    // eslint-disable-next-line
    for (let prop in c) {
      guestCare[prop] = c[prop];
    }
    return guestCare;
  }

  confirmOnOFF(guest: IGuestCareProduct) {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn xóa người quan tâm này khônng?',
      accept: () => {
        this.setActive(guest);
      }
    });
  }
  setActive(guest: any) {
    this.guestCareService.delete(guest.id).subscribe(response => {
      if (response.status === 200) {
        this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã xóa thàng công thành công người quan tâm!' });
        this.fetch();
      } else {
        this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Xóa  thất bại!' });
      }
    });
  }

  private onSuccess(data, headers) {
    this.loading = false;
    this.totalRecords = headers.get('X-Total-Count');
    this.guests = data;
    // eslint-disable-next-line
    console.log('guest', this.guests);
  }
  private onError(error) {
    this.loading = false;
    this.alertService.error(error.error, error.message, null);
  }

  selectGuestRow(event) {
    // eslint-disable-next-line
    console.log('qua day');
    this.router.navigate(['/product', event.data.productPost.id, 'productdetail']);
  }
}
