import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules, PreloadingStrategy } from '@angular/router';
import { ErrorComponent } from './views/error/error.component';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./views/home/home.module').then(m => m.HomeModule)
  },
  // {
  //   path: 'login',
  //   component: LoginComponent,
  //   data: {
  //     title: 'Đăng nhập'
  //   }
  // },
  {
    path: 'search',
    loadChildren: () => import('./views/search/search.module').then(m => m.SearchModule)
  },
  {
    path: 'listproduct',
    loadChildren: () => import('./views/listproduct/listproduct.module').then(m => m.ListproductModule)
  },
  {
    path: 'product',
    loadChildren: () => import('./views/productdetail/productdetail.module').then(m => m.ProductModule)
  },
  {
    path: 'news',
    loadChildren: () => import('./views/news/news.module').then(m => m.NewsModule)
  },

  {
    path: 'fengshui',
    loadChildren: () => import('./views/fengshui/fengshui.module').then(m => m.FengShuiModule)
  },
  {
    path: 'admin',
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
    path: '404',
    component: ErrorComponent,
    data: {
      title: 'Page 404'
    }
  }
  //   },
  //   {
  //     path: '403',
  //     component: P403Component,
  //     data: {
  //       title: 'Page 403'
  //     }
  //   },
  //   {
  //     path: '404',
  //     component: P404Component,
  //     data: {
  //       title: 'Page 404'
  //     }
  //   },
  //   {
  //     path: '500',
  //     component: P500Component,
  //     data: {
  //       title: 'Page 500'
  //     }
  //   },
  //   {
  //     path: '**',
  //     redirectTo: '/404'
  //   }
  // ],
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true, preloadingStrategy: PreloadAllModules })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
