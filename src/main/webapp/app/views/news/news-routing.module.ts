import { NgModule, Injectable } from '@angular/core';
import { Routes, RouterModule, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { NewsComponent } from './news.component';
import { NewspageComponent } from './newspage/newspage.component';
import { NewsdetailComponent } from './newsdetail/newsdetail.component';
import { NewsService } from 'app/core/service/news.service';

@Injectable({ providedIn: 'root' })
export class DetailNewResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: NewsService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params.id ? route.params.id : null;
    if (id) {
      return this.service.getDetailNews(id);
    }
    return new this.detainew();
  }
}
const routes: Routes = [
  {
    path: '',
    component: NewsComponent,
    data: {
      title: 'Tin tức'
    },
    children: [
      {
        path: '',
        component: NewspageComponent
      },
      {
        path: ':id/detail',
        component: NewsdetailComponent,
        resolve: {
          detailNew: DetailNewResolve
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewsRoutingModule { }
