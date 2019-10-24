import { NgModule, Injectable } from '@angular/core';
import { Routes, RouterModule, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { PostproductComponent } from './postproduct.component';
import { NewsService } from 'app/core/service/news.service';

@Injectable({ providedIn: 'root' })
export class DetailNewResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: NewsService) {}

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
