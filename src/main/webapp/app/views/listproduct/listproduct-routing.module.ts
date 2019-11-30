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
    const postType = route.params.postType ? route.params.postType : null;
    if (type !== null && postType !== null) {
      // eslint-disable-next-line
      console.log('valuetype', type);
      return this.service.listAllByType(type, postType);
    }
    return new this.detainew();
  }
}

@Injectable({ providedIn: 'root' })
export class TypeChildResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: PostService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const typechild = route.params.typechild ? route.params.typechild : null;
    const postType = route.params.postType ? route.params.postType : null;
    if (typechild !== null && postType !== null) {
      return this.service.listAllByTypeChild(typechild, postType);
    }
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
        path: 'typeSearch/:type/:postType/:title/:titleChild',
        component: ListproductComponent,
        resolve: {
          typeSearch: TypeResolve
        },
        data: {
          breadcrumb: [
            {
              label: '{{title}}',
              url: '/admin'
            },
            {
              label: '{{titleChild}}',
              url: ''
            }
          ]
        }
      },
      {
        path: 'typeChildSearch/:typechild/:postType/:title/:titleChild/:titleVeryChild',
        component: ListproductComponent,
        resolve: {
          typeSearch: TypeChildResolve
        },
        data: {
          breadcrumb: [
            {
              label: '{{title}}',
              url: '/admin'
            },
            {
              label: '{{titleChild}}',
              url: '/admin'
            },
            {
              label: '{{titleVeryChild}}',
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
export class ListproductRoutingModule {}
