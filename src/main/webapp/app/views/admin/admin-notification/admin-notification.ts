import { Component, OnInit, ElementRef, Renderer } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Validators, FormBuilder } from '@angular/forms';
import { JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { SERVER_API_URL } from 'app/app.constants';
import { INotification, Notification } from 'app/core/notification/notification.model';
import { IUser } from 'app/core/user/user.model';
import { Account } from 'app/core/user/account.model';
import { NotificationService } from 'app/core/notification/notification.service';

@Component({
  selector: 'app-admin-notification',
  templateUrl: './admin-notification.html',
  styleUrls: ['./admin-notification.scss'],
  providers: [ConfirmationService, MessageService]
})
export class AdminNotificationComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  send = this.fb.group({
    content: [null, Validators.required]
  });
  notification: INotification;
  currentAccount: Account;
  currentUser: IUser;
  constructor(
    private fb: FormBuilder,
    private elementRef: ElementRef,
    private renderer: Renderer,
    private confirmationService: ConfirmationService,
    private alertService: JhiAlertService,
    private router: Router,
    private accountService: AccountService,
    private userService: UserService,
    private messageService: MessageService,
    private notificationService: NotificationService
  ) {}

  ngOnInit() {
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
      });
    });
  }
  sendNotiToUser() {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn gửi thông báo này?',
      accept: () => {
        this.notification = new Notification();
        this.notification.type = 2;
        this.notification.userSend = this.currentUser.id;
        this.notification.content = this.send.controls.content.value;
        this.notification.title = 'Thông báo từ quản trị viên';
        this.notificationService.sendMessageToUser(this.notification).subscribe(res => {
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã gửi thông báo thành công!' });
        });
      }
    });
  }
}
