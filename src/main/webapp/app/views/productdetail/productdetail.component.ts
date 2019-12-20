import { Component, OnInit } from '@angular/core';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { ActivatedRoute, Router } from '@angular/router';
import { SERVER_API_URL } from 'app/app.constants';
import { NewsService } from 'app/core/news/news.service';
import { FormBuilder, Validators } from '@angular/forms';
import { NotificationService } from 'app/core/notification/notification.service';
import { IGuestCareProduct } from 'app/core/guest-care-product/guest-care-product.model';
import { GuestCareProductService } from 'app/core/guest-care-product/guest-care-product.service';
import { JhiAlertService } from 'ng-jhipster';
import { MessageService } from 'primeng/api';
import { INotification, Notification } from 'app/core/notification/notification.model';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';
import { LikedService } from 'app/core/liked/liked.service';
import { LikedPost } from 'app/core/liked/model/liked-post.model';
declare global {
  interface Window {
    FB: any;
  }
}
@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.scss'],
  providers: [MessageService]
})
export class ProductdetailComponent implements OnInit {
  FB = window.FB;
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  images: any[];
  listImage: any = [];
  productdetail: any;
  list4News: any[];
  productdetal: PostRespone;
  notification: INotification;
  currentAccount: Account;
  currentUser: IUser;
  liked = false;
  likedPost: LikedPost;
  currentUrl: string;
  inforForm = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(32), Validators.pattern('^[a-zA-Z- ]*$')]],
    phone: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(12), Validators.pattern('^[0-9]*$')]],
    email: [
      '',
      [Validators.required, Validators.minLength(6), Validators.maxLength(50), Validators.pattern('[a-zA-Z0-9._]+@[a-z0-9.-]+.[a-z]{2,}$')]
    ],
    mess: ['', [Validators.maxLength(200)]]
  });
  constructor(
    private newService: NewsService,
    private activatedRoute: ActivatedRoute,
    private notificationService: NotificationService,
    private guestCareProductService: GuestCareProductService,
    private fb: FormBuilder,
    private alertService: JhiAlertService,
    private messageService: MessageService,
    private accountService: AccountService,
    private userService: UserService,
    private router: Router,
    private likedService: LikedService
  ) {}
  ngOnInit() {
    window.FB.XFBML.parse();
    this.currentUrl = window.location.origin + this.router.url;
    // eslint-disable-next-line
    console.log(window.location.origin + this.currentUrl);
    this.activatedRoute.data.subscribe(res => {
      this.productdetail = res.detailProduct;
      // eslint-disable-next-line
      console.log(' post : ', this.productdetail.productPostResponseDTO.id);
      // eslint-disable-next-line
      console.log(' user : ', this.currentUser);
      this.listImage.push(this.productdetail.imageDTO.img1);
      this.listImage.push(this.productdetail.imageDTO.img2);
      this.listImage.push(this.productdetail.imageDTO.img3);
      this.listImage.push(this.productdetail.imageDTO.img4);
      this.listImage.push(this.productdetail.imageDTO.img5);
      this.listImage.push(this.productdetail.imageDTO.img6);
      this.listImage.push(this.productdetail.imageDTO.img7);
      this.listImage.push(this.productdetail.imageDTO.img8);
      this.listImage.push(this.productdetail.imageDTO.img9);
      this.listImage.push(this.productdetail.imageDTO.img10);
      this.accountService.identity().subscribe((account: Account) => {
        this.currentAccount = account;
        this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
          this.currentUser = userAuthen;
          this.likedService.checkStatusPost(this.currentUser.id, this.productdetail.productPostResponseDTO.id).subscribe(post => {
            this.likedPost = post.body;
            this.liked = this.likedPost.status;
          });
        });
      });
    });

    this.getlist4News();
  }

  /*  get  list 4 new*/
  getlist4News() {
    this.newService.getListNews().subscribe(res => {
      this.list4News = res.body;
      this.list4News.sort(function(obj1, obj2) {
        return new Date(obj2.createdDate).valueOf() - new Date(obj1.createdDate).valueOf();
      });
      this.list4News = res.body.slice(0, 4);
    });
  }

  goToNews(id: any) {
    // tslint:disable-next-line: no-unused-expression
    this.router.navigate(['/news', id, 'detail']);
  }
  send() {
    const data: IGuestCareProduct = this.inforForm.getRawValue();
    data.user = this.productdetail.productPostResponseDTO.user.id;
    data.productPost = this.productdetail.productPostResponseDTO.id;
    this.notification = new Notification();
    this.notification.type = 1;
    this.notification.userSend = this.currentUser.id;
    this.notification.content = 'muốn liên hệ với bạn';
    this.notification.userReceive = this.productdetail.productPostResponseDTO.user.id;
    this.notification.title = 'Liên hệ';
    this.guestCareProductService
      .create(data)
      .subscribe(
        () => (
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

  checkLike(postId) {
    // eslint-disable-next-line
    console.log('user  : ', this.currentUser);
    this.likedService.checkLikedPost(this.currentUser.id, postId).subscribe(res => {
      this.likedPost = res.body;
      this.liked = this.likedPost.status;
    });
  }

  isAuthenticated() {
    return this.accountService.isAuthenticated();
  }
}
