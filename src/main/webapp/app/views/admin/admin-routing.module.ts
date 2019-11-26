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
      title: 'Quản lí chung'
    },
    children: [
      {
        path: '',
        component: ManageUserComponent
      },
      {
        path: 'manageallproductpost',
        component: ManageAllProductpostComponent
      },
      {
        path: 'manage-user',
        component: ManageUserComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {}
