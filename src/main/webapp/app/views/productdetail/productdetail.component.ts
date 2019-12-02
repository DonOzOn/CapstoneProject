import { Component, OnInit } from '@angular/core';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { ActivatedRoute } from '@angular/router';
import { SERVER_API_URL } from 'app/app.constants';
import { NewsService } from 'app/core/news/news.service';
import { FormBuilder, Validators } from '@angular/forms';
import { NotificationService } from 'app/core/notification/notification.service';
import { IGuestCareProduct } from 'app/core/guest-care-product/guest-care-product.model';
import { GuestCareProductService } from 'app/core/guest-care-product/guest-care-product.service';
import { JhiAlertService } from 'ng-jhipster';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.scss'],
  providers: [MessageService]
})
export class ProductdetailComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  images: any[];
  listImage: any = [];
  productdetail: any;
  listNews: any[];
  productdetal: PostRespone;
  inforForm = this.fb.group({
    name: ['', Validators.maxLength(50)],
    phone: ['', [Validators.required, Validators.minLength(9), Validators.maxLength(12)]],
    email: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(256)]],
    mess: ['', [Validators.maxLength(200)]]
  });
  constructor(
    private newService: NewsService,
    private activatedRoute: ActivatedRoute,
    private notificationService: NotificationService,
    private guestCareProductService: GuestCareProductService,
    private fb: FormBuilder,
    private alertService: JhiAlertService,
    private messageService: MessageService
  ) {}
  ngOnInit() {
    this.activatedRoute.data.subscribe(res => {
      this.productdetail = res.detailProduct;
      // eslint-disable-next-line
      console.log(' post : ', this.productdetail.imageDTO);
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
    });
    // eslint-disable-next-line
    console.log(' post : ', this.listImage);
    this.getlistNews();
  }
  /*  get  list 4 new*/
  getlistNews() {
    this.newService.getListNews().subscribe(res => {
      this.listNews = res.body;
      this.listNews.sort(function(obj1, obj2) {
        return obj2.timeCreate - obj1.timeCreate;
      });
      this.listNews = res.body.slice(0, 4);
    });
  }
  send() {
    const data: IGuestCareProduct = this.inforForm.getRawValue();
    data.user = this.productdetail.productPostResponseDTO.user.id;
    data.productPost = this.productdetail.productPostResponseDTO.id;
    this.guestCareProductService
      .create(data)
      .subscribe(() => this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã gửi liên hệ thành công!' })),
      // eslint-disable-next-line
      (err: any) => (
        this.alertService.error(err.error.title),
        this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Gửi liên hệ  thất bại!' })
      );

    this.notificationService
      .sendMessage(
        'dySN_Pgy_xc:APA91bHXer2Gm9CeKYxdc3HZJk0PwcxvUt9dGZallmU6GwcCe5uxND1zGZWYftabzygyrqweItnbMZEVa9l-AZUHpW01MNuH3X4DNSsSIOU5zaL1FObo4d6LW533ne7nm_-HKhXVEBv-'
      )
      .subscribe();
  }
}
