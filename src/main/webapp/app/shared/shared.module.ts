import { NgModule } from '@angular/core';
import { RealestatebrokerageSharedLibsModule } from './shared-libs.module';
import { JhiAlertComponent } from './alert/alert.component';
import { JhiAlertErrorComponent } from './alert/alert-error.component';
import { JhiLoginModalComponent } from './login/login.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';
import { PasswordStrengthBarComponent } from './password-strength/password-strength-bar.component';
import { NewComponent } from './new/new.component';
import { RouterModule } from '@angular/router';
import { CareYouComponent } from './care-you/care-you.component';
import { ShowHidePasswordModule } from 'ngx-show-hide-password';

@NgModule({
  imports: [RealestatebrokerageSharedLibsModule, RouterModule, ShowHidePasswordModule],
  declarations: [
    JhiAlertComponent,
    JhiAlertErrorComponent,
    JhiLoginModalComponent,
    HasAnyAuthorityDirective,
    PasswordStrengthBarComponent,
    NewComponent,
    CareYouComponent
  ],
  entryComponents: [JhiLoginModalComponent],
  exports: [
    RealestatebrokerageSharedLibsModule,
    JhiAlertComponent,
    JhiAlertErrorComponent,
    JhiLoginModalComponent,
    HasAnyAuthorityDirective,
    PasswordStrengthBarComponent,
    NewComponent,
    CareYouComponent
  ]
})
export class RealestatebrokerageSharedModule {}
