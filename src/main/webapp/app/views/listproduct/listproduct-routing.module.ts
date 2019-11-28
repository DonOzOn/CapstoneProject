import { NgModule, Injectable } from '@angular/core';
import { Routes, RouterModule, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { ListproductComponent } from './listproduct.component';
import { PostService } from 'app/core/post/post.service';

@Injectable({ providedIn: 'root' })
export class TypeResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: PostService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const type = route.params.type ? route.params.type : null;
    if (type) {
      // eslint-disable-next-line
      console.log('valuetype', type);
      return this.service.listAllByType(type);
    }
    return new this.detainew();
  }
}
@Injectable({ providedIn: 'root' })
export class TypeChildResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: PostService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const typechild = route.params.id ? route.params.id : null;
    // if (typechild) {

    // }
    return new this.detainew();
  }
}
const routes: Routes = [
  {
    path: '',
    component: ListproductComponent,
    data: {
      title: 'Listproduct'
    },
    children: [
      {
        path: ':type/typeSearch',
        component: ListproductComponent,
        resolve: {
          typeSearch: TypeResolve,
          type: 'abc'
        }
      },
      {
        path: ':typechild/typeChildSearch',
        component: ListproductComponent,
        resolve: {
          typeChildSearch: TypeChildResolve
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListproductRoutingModule {}
