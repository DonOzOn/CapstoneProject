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

@Injectable({ providedIn: 'root' })
export class PostTypeResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: PostService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const postType = route.params.postType ? route.params.postType : null;
    if (postType) {
      return this.service.listAllByProductPostType(postType);
    }
    return new this.detainew();
  }
}

@Injectable({ providedIn: 'root' })
export class ProvinceResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: PostService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const province = route.params.province ? route.params.province : null;
    if (province) {
      return this.service.listAllByProvince(province);
    }
    return new this.detainew();
  }
}

@Injectable({ providedIn: 'root' })
export class UserResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: PostService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const userId = route.params.userId ? route.params.userId : null;
    if (userId) {
      return this.service.listAllByUserID({ id: userId, page: 0, size: 10, sort: null });
    }
    return new this.detainew();
  }
}

@Injectable({ providedIn: 'root' })
export class FullTextSearchResolve implements Resolve<any> {
  detainew: any;
  constructor(private service: PostService) {}
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const textSearch = route.params.textSearch ? route.params.textSearch : null;
    if (textSearch) {
      return this.service.fullTextSearch(textSearch);
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
              label: 'Trang chủ',
              url: '/home'
            },
            {
              label: '{{title}}',
              url: '/postTypeSearch/:postType/:title'
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
              label: 'Trang chủ',
              url: '/home'
            },
            {
              label: '{{title}}',
              url: '/postTypeSearch/:postType/:title'
            },
            {
              label: '{{titleChild}}',
              url: ''
            },
            {
              label: '{{titleVeryChild}}',
              url: ''
            }
          ]
        }
      },
      {
        path: 'postTypeSearch/:postType/:postTypeName',
        component: ListproductComponent,
        resolve: {
          typeSearch: PostTypeResolve
        },
        data: {
          breadcrumb: [
            {
              label: 'Trang chủ',
              url: '/home'
            },
            {
              label: '{{postTypeName}}',
              url: ''
            }
          ]
        }
      },
      {
        path: 'postByProvince/:province/:provinceName',
        component: ListproductComponent,
        resolve: {
          typeSearch: ProvinceResolve
        },
        data: {
          breadcrumb: [
            {
              label: 'Trang chủ',
              url: '/home'
            },
            {
              label: '{{provinceName}}',
              url: ''
            }
          ]
        }
      },
      {
        path: 'fullTextSearch/:textSearch',
        component: ListproductComponent,
        resolve: {
          typeSearch: FullTextSearchResolve
        }
      },
      {
        path: 'user/:userId/:Loginname',
        component: ListproductComponent,
        resolve: {
          typeSearch: UserResolve
        },
        data: {
          breadcrumb: [
            {
              label: 'Trang chủ',
              url: '/home'
            },
            {
              label: '{{Loginname}}',
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
