import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LawComponent } from './law.component';
import { LawsellComponent } from './lawsell/lawsell.component';
import { LawpageComponent } from './lawpage/lawpage.component';
import { LawrentComponent } from './lawrent/lawrent.component';
import { ContracformComponent } from './contracform/contracform.component';
import { AddresscontractComponent } from './addresscontract/addresscontract.component';

const routes: Routes = [
  {
    path: '',
    component: LawComponent,
    data: {
      title: 'Thư viện pháp luật'
    },
    children: [
      {
        path: '',
        component: LawpageComponent
      },
      {
        path: 'lawsell',
        component: LawsellComponent
      },
      {
        path: 'lawrent',
        component: LawrentComponent
      },
      {
        path: 'contractform',
        component: ContracformComponent
      },
      {
        path: 'addresscontract',
        component: AddresscontractComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LawRoutingModule {}
