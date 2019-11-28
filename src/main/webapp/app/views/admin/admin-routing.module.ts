import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { ManageAllProductpostComponent } from './manage-allproductpost/manage-allproductpost';
import { ManageUserComponent } from './manage-user/manage-user.component';

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
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {}
