import { Component, OnInit, ElementRef, Renderer } from '@angular/core';
import { SelectItem, ConfirmationService, MessageService } from 'primeng/api';
import { Validators, FormBuilder } from '@angular/forms';
import { IUser } from 'app/core/user/user.model';
import { AddressService } from 'app/core/address/address.service';
import { ProductPostTypeService } from 'app/core/product-type/product-type.service';
import { JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';
import { PostService } from 'app/core/post/post.service';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { Account } from 'app/core/user/account.model';
import { HttpErrorResponse } from '@angular/common/http';
import { SERVER_API_URL } from 'app/app.constants';
import { IReview } from 'app/core/review/review.model';
import { ReviewService } from 'app/core/review/review.service';

@Component({
  selector: 'app-manage-all-reviewpost',
  templateUrl: './manage-all-reviewpost.component.html',
  styleUrls: ['./manage-all-reviewpost.component.scss'],
  providers: [ConfirmationService, MessageService]
})
export class ManagereAllReviewpostComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  /*  Item select button  */
  selectedType: number;
  types: SelectItem[];
  isUploadedFile = false;
  text1: String = '<div>Hello!</div><div>Chào mừng tới BDS</div><div><br></div>';
  /* product post */
  account: Account;
  user: IUser;
  /*  List product type and product type child  */
  listProductTypeChild: [];
  listProductType: [];
  uploadedFiles: any[] = [];
  countContent: any = 0;
  listUtilitiesSelected = [];
  listImageName = [];
  /*  Form product post */
  reviewPostForm = this.fb.group({
    title: [null, [Validators.maxLength(100), Validators.required]],
    content: [null, [Validators.required]],
    decription: [null, [Validators.maxLength(200)]],
    type: [null]
  });

  review: IReview;

  reviews: IReview[];

  selectedReview: IReview;

  displayDialog: boolean;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;

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
    private postService: PostService,
    private accountService: AccountService,
    private userService: UserService,
    private messageService: MessageService,
    private reviewService: ReviewService
  ) {
    this.types = [{ label: 'Review', value: 0 }, { label: 'Câu hỏi', value: 1 }];
  }

  ngOnInit() {
    // this.selectedType = 'Mua bán';
  }

  /**
   * delete post
   * @param event
   * @param post
   */
  deleteSelectReview(id: any) {
    // eslint-disable-next-line
    console.log('id: ', id);

    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn ẩn bài đăng này?',
      accept: () => {
        this.alertService.clear();
        this.reviewService.delete(id).subscribe(() => {
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã ẩn bài đăng thành công!!' });
          this.getListReview();
        });
      }
    });
  }

  selectReview(event: Event, review: IReview) {
    this.alertService.success('Chọn ' + review.id, null, null), (this.displayDialog = true);
    // eslint-disable-next-line
    console.log('IReview: ', review);
    if (review.type === true) {
      this.selectedType = this.types[1].value;
    } else {
      this.selectedType = this.types[0].value;
    }
    this.review = review;
    this.uploadedFiles[0] = review.imageUrl;
    this.reviewPostForm.controls.title.setValue(review.title);
    this.reviewPostForm.controls.decription.setValue(review.decription);
    this.reviewPostForm.controls.content.setValue(review.content);
    this.text1 = review.content;
    // event.preventDefault();
  }

  /**
   * Selects onchange
   * @param event
   */
  selectOnchange(event) {
    // eslint-disable-next-line
    console.log('value select : ', event.value);
    if (event.value === 0) {
      this.reviewPostForm.controls.type.setValue(false);
    } else {
      this.reviewPostForm.controls.type.setValue(true);
    }
  }

  loadData(event) {
    event.first = true;
    event.rows = 10;
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
      });
    });
    this.getListReview();
    this.sortOptions = [{ label: 'Mới nhất', value: 1 }, { label: 'Cũ nhất', value: 2 }];
  }

  /**
   * Gets list review
   * @param id
   */
  getListReview() {
    this.reviewService.getListReview().subscribe(res => {
      this.reviews = res.body;
      this.reviews.sort(function(obj1: any, obj2: any) {
        return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
      });
      // eslint-disable-next-line
      console.log('List all review : ', this.reviews);
    });
  }

  /**
   * Determines whether sort change on
   * @param event
   */
  onSortChange(event: { value: any }) {
    // eslint-disable-next-line
    console.log('key : ', this.sortKey);
    const value = event.value;
    switch (value) {
      case 1: {
        this.reviews.sort(function(obj1: any, obj2: any) {
          return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
        });
        break;
      }
      case 2: {
        this.reviews.sort(function(obj1: any, obj2: any) {
          return new Date(obj1.createdDate).valueOf() - new Date(obj2.createdDate).valueOf();
        });
        break;
      }

      default: {
        break;
      }
    }
  }
  /**
   * Determines whether dialog hide on
   */
  onDialogHide() {
    this.redirectTo('/manage-review');
  }

  /**
   * Determines whether show dialog on
   */
  onShowDialog() {}

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
      this.postService.upload(element).subscribe(
        res => {
          this.uploadedFiles.pop();
          this.uploadedFiles.push(res.body);
          this.isUploadedFile = true;
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Dã tải ảnh thành công!!' });
        },
        (err: HttpErrorResponse) => {
          this.isUploadedFile = false;
          this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Tải ảnh thất bại!!' });
        }
      );
    });
    fileUpload.clear();
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

  redirectTo(uri: string) {
    this.router.navigateByUrl('/usermanage', { skipLocationChange: true }).then(() => this.router.navigate([uri]));
  }

  /**
   * submit form
   */
  updateReview() {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn sửa bài đăng này?',
      accept: () => {
        const data: IReview = this.reviewPostForm.getRawValue();
        data.id = this.review.id;
        data.imageUrl = this.uploadedFiles[0];
        this.alertService.clear();
        this.reviewService.update(data).subscribe(
          () => (
            (this.displayDialog = false),
            this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã đăng bài thành công!' }),
            this.alertService.success('Cập nhật thành công bài review ' + data.id, null, null)
            // this.redirectTo('/manage-review')
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
