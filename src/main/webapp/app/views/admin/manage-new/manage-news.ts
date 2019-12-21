import { Component, OnInit, ElementRef, Renderer, ViewChild } from '@angular/core';
import { SelectItem, ConfirmationService, MessageService, LazyLoadEvent } from 'primeng/api';
import { Validators, FormBuilder } from '@angular/forms';
import { ProductPost } from 'app/core/post/model/product-post.model';
import { IUser } from 'app/core/user/user.model';
import { AddressService } from 'app/core/address/address.service';
import { ProductPostTypeService } from 'app/core/product-type/product-type.service';
import { JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { Account } from 'app/core/user/account.model';
import { SERVER_API_URL } from 'app/app.constants';
import { News, INews } from 'app/core/news/news.model';
import { NewsService } from 'app/core/news/news.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Table } from 'primeng/table';

@Component({
  selector: 'app-news',
  templateUrl: './manage-news.html',
  styleUrls: ['./manage-news.component.scss'],
  providers: [ConfirmationService, MessageService]
})
export class ManageNewsComponent implements OnInit {
  @ViewChild('dv', { static: false }) dv: Table;
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  fromDate = new Date();
  toDate = new Date();
  totalRecords = 0;
  loading: boolean;
  // from = new FormControl('');
  // to = new FormControl('');
  from: any;
  to: any;
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
  productPost: ProductPost;
  account: Account;
  user: IUser;
  /*  List product type and product type child  */
  listProductTypeChild: [];
  listProductType: [];
  uploadedFiles: any[] = [];
  countContent: any = 0;
  isUploadedFile: boolean;
  listImageName = [];
  /*  Form product post */
  newsPostForm = this.fb.group({
    title: [null, [Validators.maxLength(100), Validators.required]],
    decription: [null, [Validators.maxLength(200), Validators.required]],
    content: [null, [Validators.required]]
  });
  news: INews[];

  new: INews;

  selectedNews: News;

  displayDialog: boolean;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;
  constructor(
    private addressService: AddressService,
    private fb: FormBuilder,
    private productPostTypeService: ProductPostTypeService,
    private elementRef: ElementRef,
    private renderer: Renderer,
    private confirmationService: ConfirmationService,
    private alertService: JhiAlertService,
    private router: Router,
    private newsService: NewsService,
    private accountService: AccountService,
    private userService: UserService,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.loading = true;
    this.sortOptions = [{ label: 'Mới nhất', value: 1 }, { label: 'Cũ nhất', value: 2 }];
  }

  /**
   * To change
   * @param value
   */
  toChange(value) {
    if (this.from == null) {
      if (this.to == null) {
        this.fetch();
      }
    } else {
      if (this.from > this.to) {
        if (this.to == null) {
          // eslint-disable-next-line
          console.log('to', new Date(this.to).toISOString());
        }
      } else {
        this.fromDate = new Date(this.from);
        this.fromDate.setHours(0, 0, 0);
        this.toDate = new Date(this.to);
        this.toDate.setHours(0, 0, 0);
        this.newsService.searchbyDate(this.fromDate.toISOString(), this.toDate.toISOString()).subscribe(res => {
          this.news = res.body;
        });
      }
    }
  }

  /**
   * Froms change
   * @param value
   */
  fromChange(value) {
    if (this.to == null) {
      if (this.to == null) {
        this.fetch();
      }
      this.messageService.add({ severity: 'error', summary: 'Thiếu!', detail: 'Vui lòng chọn ngày kết thúc!' });
    } else {
      if (this.from > this.to) {
        this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Ngày kết thúc phải lớn hơn ngày bắt đầu!' });
      } else {
        this.fromDate = new Date(this.from);
        this.fromDate.setHours(0, 0, 0);
        this.toDate = new Date(this.to);
        this.toDate.setHours(0, 0, 0);
        this.newsService.searchbyDate(this.fromDate.toISOString(), this.toDate.toISOString()).subscribe(res => {
          this.news = res.body;
        });
      }
    }
  }
  /**
   * Return select postproduct
   * @param id
   */
  returnNews(id: any) {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn hiển thị bài đăng này?',
      accept: () => {
        this.alertService.clear();
        this.newsService.delete(id).subscribe(() => {
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã hiển thị bài đăng thành công!!' });
          this.fetch();
        });
      }
    });
  }
  /**
   * Deletes select postproduct
   * @param id
   */
  deleteNews(id: any) {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn ẩn bài đăng này?',
      accept: () => {
        this.alertService.clear();
        this.newsService.delete(id).subscribe(() => {
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã ẩn bài đăng thành công!!' });
          this.fetch();
        });
      }
    });
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
          this.uploadedFiles.pop();
          this.uploadedFiles.push(res.body);
          this.isUploadedFile = true;
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã tải ảnh thành công!!' });
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
   * click button "Tạo bài đăng tin tức"
   */
  don() {
    this.displayDialog = true;
    this.new = null;
  }

  /**
   * delete post
   * @param event
   * @param post
   */
  selectNews(event: Event, news: INews) {
    this.displayDialog = true;
    this.new = news;
    this.newsPostForm.controls.title.setValue(this.new.title);
    this.newsPostForm.controls.decription.setValue(this.new.decription);
    this.newsPostForm.controls.content.setValue(this.new.content);
    this.uploadedFiles.push(this.new.imageUrl);
    event.preventDefault();
  }

  loadData(event: LazyLoadEvent) {
    this.loading = true;
    // eslint-disable-next-line @typescript-eslint/tslint/config
    // eslint-disable-next-line prefer-const
    const sort = '';
    setTimeout(() => {
      this.fetch(event.first / event.rows, [sort]);
      this.loading = false;
    }, 500);
  }

  fetch(page = 0, sort?) {
    this.newsService
      .getListNews({ page, size: 10, sort })
      .pipe(tap(() => (this.loading = true)))
      .subscribe((res: HttpResponse<INews[]>) => this.onSuccess(res.body, res.headers), (res: HttpResponse<any>) => this.onError(res.body));
  }
  private onSuccess(data, headers) {
    this.loading = false;
    this.totalRecords = headers.get('X-Total-Count');
    this.news = data;
  }
  private onError(error) {
    this.loading = false;
    this.alertService.error(error.error, error.message, null);
  }

  /**
   * Determines whether sort change on
   * @param event
   */
  onSortChange(event: { value: any }) {
    const value = event.value;
    switch (value) {
      case 1: {
        this.news.sort(function(obj1: any, obj2: any) {
          return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
        });
        break;
      }
      case 2: {
        this.news.sort(function(obj1: any, obj2: any) {
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
    this.router.navigateByUrl('/admin', { skipLocationChange: true }).then(() => this.router.navigate([url]));
  }

  /**
   * Posts news
   */
  postNews() {
    if (this.newsPostForm.valid) {
      this.confirm();
    }
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
    // eslint-disable-next-line
    console.log('new id : ', this.new);

    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn lưu?',
      accept: () => {
        const data: INews = this.newsPostForm.getRawValue();
        data.imageUrl = this.uploadedFiles[0];
        this.alertService.clear();
        if (this.new) {
          data.id = this.new.id;
          this.newsService
            .update(data)
            .subscribe(
              () => (
                (this.displayDialog = false),
                this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã sửa bài đăng thành công!' }),
                this.redirectTo('/managenews')
              )
            ),
            // eslint-disable-next-line
            (err: any) => (
              this.alertService.error(err.error.title),
              this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Sửa bài đăng thất bại!' })
            );
        } else {
          if (!this.uploadedFiles) {
            this.messageService.add({ severity: 'warn', summary: 'Thông báo!', detail: 'Vui lòng tải ảnh bìa trước khi đăng tin!' });
          } else {
            this.newsService
              .create(data)
              .subscribe(
                () => (
                  (this.displayDialog = false),
                  this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã đăng bài đăng thành công!' }),
                  this.redirectTo('/managenews')
                )
              ),
              // eslint-disable-next-line
              (err: any) => (
                this.alertService.error(err.error.title),
                this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Đăng bài đăng thất bại!' })
              );
          }
        }
      }
    });
  }
}
