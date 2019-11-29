import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PostproductComponent } from './postproduct.component';

const routes: Routes = [
  {
    path: '',
    component: PostproductComponent,
    data: {
      title: 'Đăng tin'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PostproductRoutingModule {}
