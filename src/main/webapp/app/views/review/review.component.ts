import { Component, OnInit, ElementRef, Renderer } from '@angular/core';
import { SERVER_API_URL } from 'app/app.constants';
import { IUser } from 'app/core/user/user.model';
import { Validators, FormBuilder, FormControl } from '@angular/forms';
import { IReview } from 'app/core/review/review.model';
import { AddressService } from 'app/core/address/address.service';
import { ProductPostTypeService } from 'app/core/product-type/product-type.service';
import { ConfirmationService, MessageService, SelectItem } from 'primeng/api';
import { JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ReviewService } from 'app/core/review/review.service';
import { Account } from 'app/core/user/account.model';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.scss'],
  providers: [ConfirmationService, MessageService]
})
export class ReviewComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  fromDate = new Date();
  toDate = new Date();
  from: any;
  to: any;
  searchText = new FormControl('');
  /*  Item select button  */
  text1 = '<div>Hello!</div><div>Chào mừng tới BDS</div><div><br></div>';
  /*  List provinces, district, ward, direction */
  listProvinces = [];
  listDistrict = [];
  listWard = [];
  listDirection = [];
  listUtilities = [];
  listLegalStatus = [];
  /* product post */
  account: Account;
  user: IUser;
  /*  List product type and product type child  */
  uploadedFiles: any[] = [];
  countContent: any = 0;
  isUploadedFile: boolean;
  listImageName = [];
  /*  Form product post */
  reviewPostForm = this.fb.group({
    title: [null, [Validators.maxLength(100), Validators.required]],
    content: [this.text1],
    decription: [null, [Validators.maxLength(200)]],
    type: [null]
  });
  reviews: IReview[];

  review: IReview;

  displayDialog: boolean;

  selectedType: boolean;

  types: SelectItem[];

  currentAccount: Account;

  currentUser: IUser;

  constructor(
    private addressService: AddressService,
    private fb: FormBuilder,
    private productPostTypeService: ProductPostTypeService,
    private elementRef: ElementRef,
    private renderer: Renderer,
    private confirmationService: ConfirmationService,
    private alertService: JhiAlertService,
    private router: Router,
    private reviewService: ReviewService,
    private accountService: AccountService,
    private userService: UserService,
    private messageService: MessageService
  ) {
    this.types = [{ label: 'Review', value: true }, { label: 'Câu hỏi', value: false }];
  }

  ngOnInit() {
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
      });
    });
    this.getListReview();
  }

  isAuthenticated() {
    return this.accountService.isAuthenticated();
  }

  /**
   * Determines whether upload on
   * @param event
   * @param fileUpload
   */
  onUpload(event, fileUpload) {
    const listFile = [];
    for (const file of event.files) {
      listFile.push(file);
    }
    listFile.forEach(element => {
      this.userService.upload(element).subscribe(
        (res: any) => {
          // eslint-disable-next-line
          console.log('right: ', res.body);
          this.uploadedFiles.pop();
          this.uploadedFiles.push(res.body);
          this.isUploadedFile = true;
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Dã tải ảnh thành công!!' });
        },
        (err: HttpErrorResponse) => {
          // eslint-disable-next-line
          console.log('error: ', err);
          this.isUploadedFile = false;
          this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Tải ảnh thất bại!!' });
        }
      );
    });
    fileUpload.clear();
  }

  /**
   * Gets list review
   */
  getListReview() {
    this.reviewService.getListReview().subscribe(res => {
      this.reviews = res.body;
      this.reviews = this.reviews.filter(review => {
        return (review.status = true);
      });
    });
  }

  /**
   * click button "Tạo bài đăng tin tức"
   */
  don() {
    this.selectedType = this.types[0].value;
    this.displayDialog = true;
  }

  /**
   * Loads data
   * @param event
   */
  loadData(event) {
    event.first = true;
    event.rows = 10;
  }

  /**
   * Determines whether dialog hide on
   */
  onDialogHide() {
    this.redirectTo('/managenews');
  }

  /**
   * Determines whether show dialog on
   */
  onShowDialog() {}

  /**
   * Redirects to
   * @param url
   */
  redirectTo(url: string) {
    this.router.navigateByUrl('/usermanage', { skipLocationChange: true }).then(() => this.router.navigate([url]));
  }

  /**
   * Posts news
   */
  postReview() {
    if (this.reviewPostForm.valid) {
      // eslint-disable-next-line
      console.log('dfgdfgdfgdfgdfg: ');
      this.confirm();
    }
  }

  /**
   * Determines whether success on
   * @param data
   */
  private onSuccess(data) {
    this.reviews = data;
  }

  /**
   * Determines whether error on
   * @param error
   */
  private onError(error) {
    this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Tải tin tức thất bại!' + error });
  }

  /**
   * Determines whether remove on
   * @param event
   */
  onRemove(event) {
    const filtered = this.uploadedFiles.filter(function(value, index, arr) {
      return value.name !== event.file.name;
    });
    this.uploadedFiles = filtered;
  }

  /**
   * Confirms manage news component
   */
  confirm() {
    if (this.isUploadedFile === false) {
      this.messageService.add({ severity: 'warn', summary: 'Cảnh báo!', detail: 'Hãy tải ảnh bìa lên trước!' });
    } else {
      this.confirmationService.confirm({
        message: 'Bạn có chắc chắn muốn tạo bài đăng?',
        accept: () => {
          const data: IReview = this.reviewPostForm.getRawValue();
          data.type = this.selectedType;
          data.imageUrl = this.uploadedFiles[0];
          data.user = this.currentUser.id;
          this.alertService.clear();
          this.reviewService
            .create(data)
            .subscribe(
              () => (
                (this.displayDialog = false),
                this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã đăng bài thành công!' }),
                this.redirectTo('/manage-review')
              )
            ),
            // eslint-disable-next-line
            (err: any) => (
              this.alertService.error(err.error.title),
              this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Đăng bài đăng thất bại!' })
            );
        }
      });
    }
  }
  /**
   * Count content length
   */
  countContentNumber() {
    if (this.text1 != null) {
      this.countContent = this.text1;
      return true;
    } else {
      this.countContent = 0;
      return false;
    }
  }

  /**
   * Searchs
   */
  search() {
    this.router.navigate(['/searchReview', this.searchText.value]);
  }
}
