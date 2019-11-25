import { NgModule } from '@angular/core';
import { RealestatebrokerageSharedLibsModule } from './shared-libs.module';
import { JhiAlertComponent } from './alert/alert.component';
import { JhiAlertErrorComponent } from './alert/alert-error.component';
import { JhiLoginModalComponent } from './login/login.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';
import { PasswordStrengthBarComponent } from './password-strength/password-strength-bar.component';

@NgModule({
  imports: [RealestatebrokerageSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent, JhiLoginModalComponent, HasAnyAuthorityDirective, PasswordStrengthBarComponent],
  entryComponents: [JhiLoginModalComponent],
  exports: [
    RealestatebrokerageSharedLibsModule,
    JhiAlertComponent,
    JhiAlertErrorComponent,
    JhiLoginModalComponent,
    HasAnyAuthorityDirective,
    PasswordStrengthBarComponent
  ]
})
export class RealestatebrokerageSharedModule {}
