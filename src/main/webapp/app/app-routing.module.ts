import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErrorComponent } from './views/error/error.component';
import { LoginComponent } from './views/login/login.component';
import { RegisterComponent } from './views/register/register.component';
import { UserRouteAccessService } from './core/auth/user-route-access-service';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./views/home/home.module').then(m => m.HomeModule)
  },
  {
    path: 'login',
    component: LoginComponent,
    data: {
      title: 'Đăng nhập'
    }
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: {
      title: 'Đăng kí'
    }
  },
  {
    path: 'listproduct',
    loadChildren: () => import('./views/listproduct/listproduct.module').then(m => m.ListproductModule)
  },
  {
    path: 'news',
    loadChildren: () => import('./views/news/news.module').then(m => m.NewsModule)
  },
  {
    path: 'product',
    loadChildren: () => import('./views/productdetail/productdetail.module').then(m => m.ProductModule)
  },
  {
    path: 'fengshui',
    loadChildren: () => import('./views/fengshui/fengshui.module').then(m => m.FengShuiModule)
  },
  {
    path: 'admin',
    data: {
      authorities: ['ROLE_ADMIN']
    },
    canActivate: [UserRouteAccessService],
    loadChildren: () => import('./views/admin/admin.module').then(m => m.AdminModule)
  },
  {
    path: 'law',
    loadChildren: () => import('./views/law/law.module').then(m => m.LawModule)
  },
  {
    path: 'review',
    loadChildren: () => import('./views/review/review.module').then(m => m.ReviewModule)
  },
  {
    path: 'postproduct',
    loadChildren: () => import('./views/postproduct/postproduct.module').then(m => m.PostProductModule)
  },
  {
    path: 'usermanage',
    loadChildren: () => import('./views/usermanage/usermanage.module').then(m => m.UsermanageModule)
  },
  {
    path: 'account',
    loadChildren: () => import('./views/account/account.module').then(m => m.RealestatebrokerageAccountModule)
  },
  {
    path: '404',
    component: ErrorComponent,
    data: {
      title: 'Page 404'
    }
  },
  {
    path: '403',
    component: ErrorComponent,
    data: {
      title: 'Page 403'
    }
  },
  {
    path: '500',
    component: ErrorComponent,
    data: {
      title: 'Page 500'
    }
  }
  // ,
  // {
  //   path: '**',
  //   redirectTo: '/404'
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true, scrollPositionRestoration: 'top' })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
