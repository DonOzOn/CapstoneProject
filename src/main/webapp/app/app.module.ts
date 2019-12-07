import './vendor.ts';
import { CoreModule } from './core/core.module';
import { MDBBootstrapModule, ButtonsModule, PopoverModule, TooltipModule, IconsModule } from 'angular-bootstrap-md';
import { HomeModule } from './views/home/home.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { SearchModule } from './views/search/search.module';
import { ListproductModule } from './views/listproduct/listproduct.module';
import { ProductModule } from './views/productdetail/productdetail.module';
import { ReviewModule } from './views/review/review.module';
import { NewsModule } from './views/news/news.module';
import { FengShuiModule } from './views/fengshui/fengshui.module';
import { AdminModule } from './views/admin/admin.module';
import { LawModule } from './views/law/law.module';
import { ErrorComponent } from './views/error/error.component';
import { PostProductModule } from './views/postproduct/postproduct.module';
import { UsermanageModule } from './views/usermanage/usermanage.module';
import { LayoutModule } from './layout/layout.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RealestatebrokerageSharedModule } from './shared/shared.module';
import { RealestatebrokerageSharedLibsModule } from './shared/shared-libs.module';
import { RealestatebrokerageAccountModule } from './views/account/account.module';
import { CheckboxModule } from 'primeng/checkbox';
import { FacebookModule } from 'ngx-facebook';
import { ToastModule } from 'primeng/toast';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { LoginModule } from './views/login/login.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [AppComponent, ErrorComponent],
  imports: [
    HomeModule,
    BrowserModule,
    SearchModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    FlexLayoutModule,
    MDBBootstrapModule.forRoot(),
    ListproductModule,
    ProductModule,
    ReviewModule,
    NewsModule,
    FengShuiModule,
    AdminModule,
    LawModule,
    ReviewModule,
    CoreModule,
    PostProductModule,
    UsermanageModule,
    IconsModule,
    TooltipModule,
    PopoverModule,
    ButtonsModule,
    FormsModule,
    ReactiveFormsModule,
    RealestatebrokerageSharedModule,
    RealestatebrokerageSharedLibsModule,
    RealestatebrokerageAccountModule,
    CheckboxModule,
    FacebookModule.forRoot(),
    MessagesModule,
    MessageModule,
    ToastModule,
    RouterModule,
    LoginModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
