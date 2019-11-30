import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsermanageComponent } from './usermanage.component';
import { ProfileComponent } from './profile/profile.component';
import { ManageproductpostComponent } from './manageproductpost/manageproductpost.component';
import { ManagereviewpostComponent } from './managereviewpost/managereviewpost.component';
import { NotificationComponent } from './notification/notification.component';

const routes: Routes = [
  {
    path: '',
    component: UsermanageComponent,
    data: {
      title: 'Quản lí tài khoản'
    },
    children: [
      {
        path: '',
        component: ProfileComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí tài khoản',
              url: '/usermanage'
            },
            {
              label: 'Thông tin cá nhân',
              url: ''
            }
          ]
        }
      },
      {
        path: 'manage-product',
        component: ManageproductpostComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí tài khoản',
              url: '/usermanage'
            },
            {
              label: 'Quản lí bài đăng mua bán',
              url: ''
            }
          ]
        }
      },
      {
        path: 'manage-review',
        component: ManagereviewpostComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí tài khoản',
              url: '/usermanage'
            },
            {
              label: 'Quản lí bài đăng review - câu hỏi',
              url: ''
            }
          ]
        }
      },
      {
        path: 'notification',
        component: NotificationComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí tài khoản',
              url: '/usermanage'
            },
            {
              label: 'Thông báo',
              url: ''
            }
          ]
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsermanageRoutingModule {}
