import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FengshuiComponent } from './fengshui.component';

const routes: Routes = [
  {
    path: '',
    component: FengshuiComponent,
    data: {
      title: 'fengshui'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FengShuiRoutingModule {}
