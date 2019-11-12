import { NgModule, Injectable } from '@angular/core';
import { Routes, RouterModule, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
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
        component: ProfileComponent
      },
      {
        path: 'manage-product',
        component: ManageproductpostComponent
      },
      {
        path: 'manage-review',
        component: ManagereviewpostComponent
      },
      {
        path: 'manage-review',
        component: ManagereviewpostComponent
      },
      {
        path: 'notification',
        component: NotificationComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsermanageRoutingModule {}
