import { NgModule, Injectable } from '@angular/core';
import { Routes, RouterModule, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { ProductdetailComponent } from './productdetail.component';
import { PostService } from 'app/core/post/post.service';

@Injectable({ providedIn: 'root' })
export class ProductDetailResolve implements Resolve<any> {
  detailProduct: any;
  constructor(private postService: PostService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const id = route.params.id ? route.params.id : null;
    if (id) {
      return this.postService.find(id);
    }
    return this.detailProduct();
  }
}

const routes: Routes = [
  {
    path: ':id/productdetail',
    component: ProductdetailComponent,
    resolve: {
      detailProduct: ProductDetailResolve
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule {}
