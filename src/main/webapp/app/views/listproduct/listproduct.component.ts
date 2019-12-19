import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { PostService } from '../../core/post/post.service';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { SERVER_API_URL } from 'app/app.constants';
import { ActivatedRoute, Router } from '@angular/router';
import { Ng7DynamicBreadcrumbService } from 'ng7-dynamic-breadcrumb';
import { AddressService } from 'app/core/address/address.service';
import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { Sort } from '@angular/material';
import { debounceTime, distinctUntilChanged, tap } from 'rxjs/operators';
import { DirectionService } from 'app/core/direction/direction.service';
import { INotification, Notification } from 'app/core/notification/notification.model';
import { IGuestCareProduct } from 'app/core/guest-care-product/guest-care-product.model';
import { GuestCareProductService } from 'app/core/guest-care-product/guest-care-product.service';
import { JhiAlertService } from 'ng-jhipster';
import { MessageService } from 'primeng/api';
import { NotificationService } from 'app/core/notification/notification.service';
import { AccountService } from 'app/core/auth/account.service';
import { IUser } from 'app/core/user/user.model';
import { Account } from 'app/core/user/account.model';
import { UserService } from 'app/core/user/user.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.scss'],
  providers: [MessageService]
})
export class ListproductComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  breadcrumbConfig: object = {
    bgColor: '#ebebeb;',
    fontSize: '18px',
    fontColor: '#0275d8',
    lastLinkColor: 'black',
    symbol: ' ▶ '
  };
  searchText = new FormControl('');
  text: '';
  filterForm = this.fb.group({
    postType: [null],
    price: [null],
    area: [null],
    province: [null],
    district: [null],
    ward: [null],
    direction: [null],
    numBathroom: [null],
    numBedroom: [null]
  });
  listProvinces: [];
  listDistrict: [];
  listWard: [];
  listDirection: [];
  config: any;
  count: any;
  currentProductPost: PostRespone = null;
  listSuggest: PostRespone[];
  listPost: any[] = [];
  listPost2: any;
  post: PostRespone[] = [];
  sortedData: any[] = [];
  pageSize = ITEMS_PER_PAGE;
  notification: INotification;
  choose = [
    { value: 1, name: 'Mới nhất' },
    { value: 2, name: 'Cũ nhất' },
    { value: 3, name: 'Giá cao nhất' },
    { value: 4, name: 'Giá thấp nhất' }
  ];
  chooseForm = this.fb.group({
    choose: ['']
  });
  public labels: any = {
    previousLabel: 'Previous',
    nextLabel: 'Next'
  };
  inforForm = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(32), Validators.pattern('^[a-zA-Z]*$')]],
    phone: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(12), Validators.pattern('^[0-9]*$')]],
    email: [
      '',
      [Validators.required, Validators.minLength(6), Validators.maxLength(50), Validators.pattern('[a-zA-Z0-9._]+@[a-z0-9.-]+.[a-z]{2,}$')]
    ],
    mess: ['', [Validators.maxLength(200)]]
  });
  currentAccount: Account;
  currentUser: IUser;
  constructor(
    private alertService: JhiAlertService,
    private messageService: MessageService,
    private guestCareProductService: GuestCareProductService,
    private directionService: DirectionService,
    private addressService: AddressService,
    private postService: PostService,
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private ng7DynamicBreadcrumbService: Ng7DynamicBreadcrumbService,
    private notificationService: NotificationService,
    private accountService: AccountService,
    private userService: UserService,
    public activeModal: NgbModal
  ) {
    for (let i = 0; i < this.count; i++) {
      this.listPost.push({
        id: i + 1,
        value: 'items number' + (i + 1)
      });
    }
    this.config = {
      itemsPerPage: 4,
      currentPage: 1,
      totalItems: this.count
    };
  }
  pageChanged(event) {
    this.config.currentPage = event;
  }

  ngOnInit() {
    const breadcrumb = { customText: 'This is Custom Text', dynamicText: 'Level 2 ' };
    this.ng7DynamicBreadcrumbService.updateBreadcrumbLabels(breadcrumb);
    this.activatedRoute.firstChild.data.subscribe(res => {
      this.post = res.typeSearch.body;
      this.currentProductPost = this.post[0];
      this.postService.listAllByProvince(this.post[0].productPostResponseDTO.province.code).subscribe(resSuggest => {
        this.listSuggest = resSuggest.body;
      });
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    });
    this.filterForm.valueChanges
      .pipe(
        debounceTime(200),
        distinctUntilChanged(),
        tap(() => this.fetch())
      )
      .subscribe();
    // this.filterFunction();
    this.getProvince();
    this.getDirection();
  }

  /**
   * Get list direction
   */
  getDirection() {
    this.directionService.getDirection().subscribe((res: any) => {
      this.listDirection = res.body;
    });
  }

  /**
   * Gets province
   */
  getProvince() {
    this.addressService.filterProvince().subscribe((res: any) => {
      this.listProvinces = res.body;
      this.selectedProvince();
    });
  }

  /**
   * Selected district
   */
  selectedDistrict() {
    if (this.filterForm.value.district != null) {
      this.addressService.filterWard(this.filterForm.value.district).subscribe((res: any) => {
        this.listWard = res.body;
        this.filterForm.controls.ward.reset();
      });
    }
  }

  /**
   * Selected province
   */
  selectedProvince() {
    if (this.filterForm.value.province != null) {
      this.addressService.filterDistrict(this.filterForm.value.province).subscribe((res: any) => {
        this.listDistrict = res.body;
        this.filterForm.controls.district.reset();
        this.filterForm.controls.ward.reset();
      });
    }
  }

  fetch() {
    const param = {
      page: 0,
      size: this.pageSize,
      sort: ['createdDate', 'desc']
    };

    if (this.filterForm.value.province) {
      if (this.filterForm.value.province !== '0') {
        param['province'] = this.filterForm.value.province;
      } else {
        delete param['province'];
      }
    }

    if (this.filterForm.value.district) {
      if (this.filterForm.value.district !== '0') {
        param['district'] = this.filterForm.value.district;
      } else {
        delete param['district'];
      }
    }

    if (this.filterForm.value.ward) {
      if (this.filterForm.value.ward !== '0') {
        param['ward'] = this.filterForm.value.ward;
      } else {
        delete param['ward'];
      }
    }

    if (this.filterForm.value.postType) {
      // eslint-disable-next-line
      console.log('postType: ', this.filterForm.value.postType);
      if (this.filterForm.value.postType === '1') {
        param['postType'] = this.filterForm.value.postType;
        // eslint-disable-next-line
        console.log('postType2222: ', this.filterForm.value.postType);
      }
      if (this.filterForm.value.postType === '2') {
        param['postType'] = this.filterForm.value.postType;
      }

      if (this.filterForm.value.postType === '0') {
        delete param['postType'];
      }
    }

    if (this.filterForm.value.price) {
      switch (this.filterForm.value.price) {
        case '1':
          param['priceFrom'] = 0;
          param['priceTo'] = 300000000;
          break;
        case '2':
          param['priceFrom'] = 300000000;
          param['priceTo'] = 500000000;
          break;
        case '3':
          param['priceFrom'] = 500000000;
          param['priceTo'] = 800000000;
          break;
        case '4':
          param['priceFrom'] = 800000000;
          param['priceTo'] = 1000000000;
          break;
        case '5':
          param['priceFrom'] = 1000000000;
          param['priceTo'] = 3000000000;
          break;
        case '6':
          param['priceFrom'] = 3000000000;
          param['priceTo'] = 5000000000;
          break;
        case '7':
          param['priceFrom'] = 5000000000;
          param['priceTo'] = 7000000000;
          break;
        case '8':
          param['priceFrom'] = 7000000000;
          param['priceTo'] = 10000000000;
          break;
        case '9':
          param['priceFrom'] = 10000000000;
          param['priceTo'] = 20000000000;
          break;
        case '10':
          param['priceFrom'] = 20000000000;
          param['priceTo'] = 30000000000;
          break;
        case '11':
          param['priceFrom'] = 30000000000;
          param['priceTo'] = 50000000000;
          break;
        case '12':
          param['priceFrom'] = 50000000000;
          break;
        default:
          delete param['priceFrom'];
          delete param['priceTo'];
          break;
      }
    }

    if (this.filterForm.value.area) {
      switch (this.filterForm.value.area) {
        case '1':
          param['areaFrom'] = 0;
          param['areaTo'] = 30;
          break;
        case '2':
          param['areaFrom'] = 30;
          param['areaTo'] = 50;
          break;
        case '3':
          param['areaFrom'] = 50;
          param['areaTo'] = 70;
          break;
        case '4':
          param['areaFrom'] = 70;
          param['areaTo'] = 100;
          break;
        case '5':
          param['areaFrom'] = 100;
          param['areaTo'] = 150;
          break;
        case '6':
          param['areaFrom'] = 150;
          param['areaTo'] = 300;
          break;
        case '7':
          param['areaFrom'] = 300;
          param['areaTo'] = 500;
          break;
        case '8':
          param['areaFrom'] = 500;
          break;
        default:
          delete param['areaFrom'];
          delete param['areaTo'];
          break;
      }
    }

    if (this.filterForm.value.direction) {
      switch (this.filterForm.value.direction) {
        case '1':
          param['direction'] = 1;
          break;
        case '2':
          param['direction'] = 2;
          break;
        case '3':
          param['direction'] = 3;
          break;
        case '4':
          param['direction'] = 4;
          break;
        case '5':
          param['direction'] = 5;
          break;
        case '6':
          param['direction'] = 6;
          break;
        case '7':
          param['direction'] = 7;
          break;
        case '8':
          param['direction'] = 8;
          break;
        default:
          delete param['direction'];
          break;
      }
    }

    if (this.filterForm.value.direction) {
      switch (this.filterForm.value.direction) {
        case '1':
          param['direction'] = 1;
          break;
        case '2':
          param['direction'] = 2;
          break;
        case '3':
          param['direction'] = 3;
          break;
        case '4':
          param['direction'] = 4;
          break;
        case '5':
          param['direction'] = 5;
          break;
        case '6':
          param['direction'] = 6;
          break;
        case '7':
          param['direction'] = 7;
          break;
        case '8':
          param['direction'] = 8;
          break;
        default:
          delete param['direction'];
          break;
      }
    }

    if (this.filterForm.value.numBathroom) {
      param['numBathroom'] = this.filterForm.value.numBathroom;
    }

    if (this.filterForm.value.numBedroom) {
      param['numBedroom'] = this.filterForm.value.numBedroom;
    }
    this.postService.filterByCharacter(param).subscribe(res => {
      this.pageSize = param.size;
      this.post = res.body ? res.body : [];
      this.sortedData = this.post.slice();
    });
  }

  /**
   * Compares listproduct component
   * @param a
   * @param b
   * @param isAsc
   * @returns
   */
  compare(a: number | string | Date, b: number | string | Date, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  }

  sortData(sort: Sort) {
    const data = this.post.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData = data;
      return;
    }
    this.sortedData = data.sort((a, b) => {
      // eslint-disable-next-line
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        // case 'code':
        //     return this.compare(a.code, b.code, isAsc);
        // case 'customer.name':
        //     return this.compare(a.customer.name, b.customer.name, isAsc);
        // case 'customer.phone':
        //     return this.compare(a.customer.phone, b.customer.phone, isAsc);
        // case 'total':
        //     return this.compare(a.sum, b.sum, isAsc);
        // case 'createdDate':
        //     return this.compare(a.createdDate, b.createdDate, isAsc);
        default:
          return 0;
      }
    });
  }

  /**
   * Redirects to
   * @param uri
   */
  redirectTo(uri: string) {
    this.router.navigateByUrl('/404', { skipLocationChange: true }).then(() => this.router.navigate([uri]));
  }

  /*  get all product post */
  getListPostProduct() {
    this.postService.query().subscribe(res => {
      this.post = res.body;
    });
  }
  /*  get total page*/
  getTotalPage() {
    this.postService.query().subscribe(res => {
      this.count = res.body.length;
      return this.count;
    });
  }
  /*  change sort */
  onChange($deviceValue) {
    switch (this.chooseForm.controls.choose.value) {
      case 1: {
        this.post.sort(function(obj1: any, obj2: any) {
          return new Date(obj2.productPostResponseDTO.createdDate).valueOf() - new Date(obj1.productPostResponseDTO.createdDate).valueOf();
        });
        break;
      }
      case 2: {
        this.post.sort(function(obj1: any, obj2: any) {
          return new Date(obj1.productPostResponseDTO.createdDate).valueOf() - new Date(obj2.productPostResponseDTO.createdDate).valueOf();
        });
        break;
      }
      case 3: {
        this.post.sort(function(obj1: any, obj2: any) {
          return obj2.productPostResponseDTO.product.price - obj1.productPostResponseDTO.product.price;
        });
        break;
      }
      case 4: {
        this.post.sort(function(obj1: any, obj2: any) {
          return obj1.productPostResponseDTO.product.price - obj2.productPostResponseDTO.product.price;
        });
        break;
      }
      default: {
        break;
      }
    }
  }
  search() {
    this.router.navigate(['/listproduct', 'fullTextSearch', this.searchText.value]);
  }
  send(iteam: any) {
    const data: IGuestCareProduct = this.inforForm.getRawValue();
    data.user = iteam.productPostResponseDTO.user.id;
    data.productPost = iteam.productPostResponseDTO.id;
    this.notification = new Notification();
    this.notification.type = 1;
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
        if (this.currentUser.id !== null && this.currentUser.id !== undefined) {
          this.notification.userSend = this.currentUser.id;
        }
      });
    });
    this.notification.content = 'muốn liên hệ với bạn';
    this.notification.userReceive = iteam.productPostResponseDTO.user.id;
    this.notification.title = 'Liên hệ';
    this.guestCareProductService
      .create(data)
      .subscribe(
        () => (
          this.activeModal.dismissAll('login success'),
          this.getDismissReason('done'),
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã gửi liên hệ thành công!' }),
          this.notificationService.sendMessageAndAddNoti(this.notification).subscribe()
        )
      ),
      // eslint-disable-next-line
      (err: any) => (
        this.alertService.error(err.error.title),
        this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Gửi liên hệ  thất bại!' })
      );
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  open(item) {
    // eslint-disable-next-line
    console.log('data clcik: ', item);
    this.currentProductPost = item;
  }
}
