import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { ManageAllProductpostComponent } from './manage-allproductpost/manage-allproductpost';
import { ManageUserComponent } from './manage-user/manage-user.component';
import { ManageNewsComponent } from './manage-new/manage-news';
import { ManagereAllReviewpostComponent } from './manage-all-reviewpost/manage-all-reviewpost.component';
import { AdminNotificationComponent } from './admin-notification/admin-notification';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    data: {
      title: 'Quản lý chung',
      breadcrumb: [
        {
          label: 'Quản lí chung',
          url: ''
        }
      ]
    },
    children: [
      {
        path: '',
        component: ManageUserComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí chung',
              url: '/admin'
            },
            {
              label: 'Quản lí người dùng',
              url: ''
            }
          ]
        }
      },
      {
        path: 'manageallproductpost',
        component: ManageAllProductpostComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí chung',
              url: '/admin'
            },
            {
              label: 'Quản lí bài đăng',
              url: ''
            }
          ]
        }
      },
      {
        path: 'manageallreview',
        component: ManagereAllReviewpostComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí chung',
              url: '/admin'
            },
            {
              label: 'Quản lí bài đăng review',
              url: ''
            }
          ]
        }
      },
      {
        path: 'managenews',
        component: ManageNewsComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí chung',
              url: '/admin'
            },
            {
              label: 'Quản lí tin tức',
              url: ''
            }
          ]
        }
      },
      {
        path: 'managenoti',
        component: AdminNotificationComponent,
        data: {
          breadcrumb: [
            {
              label: 'Quản lí chung',
              url: '/admin'
            },
            {
              label: 'Thông báo cho người dùng',
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
export class AdminRoutingModule {}
