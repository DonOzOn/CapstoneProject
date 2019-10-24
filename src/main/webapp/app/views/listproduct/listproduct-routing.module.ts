import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListproductComponent } from './listproduct.component';

const routes: Routes = [
  {
    path: '',
    component: ListproductComponent,
    data: {
      title: 'Listproduct'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListproductRoutingModule {}
