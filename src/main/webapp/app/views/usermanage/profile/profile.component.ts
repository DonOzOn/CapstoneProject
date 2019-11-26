import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { SelectItem, MessageService, ConfirmationService } from 'primeng/api';
import { AddressService } from 'app/core/address/address.service';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { Account } from 'app/core/user/account.model';
import { IUser } from 'app/core/user/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { Province } from 'app/core/address/model/province.model';
import { District } from 'app/core/address/model/district.model';
import { Ward } from 'app/core/address/model/ward.model';
import { HttpErrorResponse } from '@angular/common/http';

interface City {
  name: string;
  code: string;
}
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
  providers: [ConfirmationService, MessageService]
})
export class ProfileComponent implements OnInit {
  text: string;
  error: string;
  success: string;
  nameImage: string;
  uploadedFiles: any[] = [];
  listImage: any[] = [];
  isUploadedFile = false;
  selectedType: boolean;
  types: SelectItem[];
  date6: Date;
  currentAccount: Account;
  currentUser: IUser;
  currentProvince: Province;
  currentDistrict: District;
  currentWard: Ward;
  /* List provinces, district, ward*/
  listProvinces = [];
  listDistrict = [];
  listWard = [];
  profileForm = this.fb.group({
    firstName: [null, [Validators.required, Validators.maxLength(50)]],
    lastName: [null, [Validators.required, Validators.maxLength(50)]],
    gender: [null, Validators.required],
    phone: [null, Validators.required],
    provinceCode: [null, Validators.required],
    districtCode: [null, Validators.required],
    wardCode: [null, Validators.required],
    // avar: [null, Validators.required],
    dob: [null, Validators.required]
  });
  constructor(
    private fb: FormBuilder,
    private addressService: AddressService,
    private accountService: AccountService,
    private userService: UserService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.types = [{ label: 'Nam', value: true }, { label: 'Nữ', value: false }];
  }

  ngOnInit() {
    // indentity account
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
        if (this.currentUser.id) {
          this.profileForm.controls.firstName.setValue(this.currentUser.firstName);
          this.profileForm.controls.lastName.setValue(this.currentUser.lastName);
          this.profileForm.controls.gender.setValue(this.currentUser.gender);
          this.profileForm.controls.phone.setValue(this.currentUser.phone);
          this.currentProvince = this.currentUser.province;
          this.currentDistrict = this.currentUser.district;
          this.addressService.filterProvince().subscribe((res: any) => {
            this.listProvinces = res.body;
          });
          this.profileForm.controls.provinceCode.setValue(this.currentProvince.code);
          if (this.profileForm.value.provinceCode != null) {
            this.addressService.filterDistrict(this.profileForm.value.provinceCode).subscribe((res: any) => {
              this.listDistrict = res.body;
            });
          }
          this.profileForm.controls.districtCode.setValue(this.currentDistrict.code);
          if (this.profileForm.value.districtCode != null) {
            this.addressService.filterWard(this.profileForm.value.districtCode).subscribe((res: any) => {
              this.listWard = res.body;
            });
          }
          this.profileForm.controls.wardCode.setValue(this.currentUser.ward.code);
          this.profileForm.controls.dob.setValue(this.currentUser.dob ? new Date(this.currentUser.dob) : '');
          this.userService.getImageByName(this.currentAccount.imageUrl).subscribe(
            (res: any) => {
              this.uploadedFiles.push(res.body);
              // eslint-disable-next-line
              console.log('image test: ', res.body);
            },
            (err: HttpErrorResponse) => {
              // eslint-disable-next-line
              console.log('errorksjhfljdfh ', err);
            }
          );
          // eslint-disable-next-line
          console.log('dtaa: ', this.uploadedFiles);
        }
      });
    });
  }
  /* get ward when select distric */
  selectedDistrict() {
    if (this.profileForm.value.districtCode != null) {
      this.addressService.filterWard(this.profileForm.value.districtCode).subscribe((res: any) => {
        this.listWard = res.body;
        this.profileForm.controls.wardCode.reset();
      });
    }
  }

  /* get district when select distric */
  selectedProvince() {
    if (this.profileForm.value.provinceCode != null) {
      this.addressService.filterDistrict(this.profileForm.value.provinceCode).subscribe((res: any) => {
        this.listDistrict = res.body;
        this.profileForm.controls.districtCode.reset();
        this.profileForm.controls.wardCode.reset();
      });
    }
  }

  /*  get all provinces */
  getProvince() {
    this.addressService.filterProvince().subscribe((res: any) => {
      this.listProvinces = res.body;
      this.selectedProvince();
    });
  }

  /* upload avar */
  /*  add picture to list */
  onUpload(event, fileUpload) {
    const listFile = [];
    for (const file of event.files) {
      listFile.push(file);
    }
    listFile.forEach(element => {
      this.userService.upload(element).subscribe(
        (res: any) => {
          // eslint-disable-next-line
          console.log('right: ', res.body);
          this.uploadedFiles.push(res.body);
          this.isUploadedFile = true;
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Dã tải ảnh đại diện thành công!!' });
        },
        (err: HttpErrorResponse) => {
          // eslint-disable-next-line
          console.log('error: ', err);
          this.isUploadedFile = false;
          this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Tải ảnh đại diện thất bại!!' });
        }
      );
    });
    fileUpload.clear();
  }

  onRemove(event) {
    const filtered = this.uploadedFiles.filter(function(value, index, arr) {
      return value.name !== event.file.name;
    });
    this.uploadedFiles = filtered;
    // eslint-disable-next-line
    console.log('after delete uploadedFiles: ', this.uploadedFiles);
  }
  /**
   * update user information
   */
  updateProfile() {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn cập nhật thông tin không?',
      accept: () => {
        const data: IUser = this.currentUser;
        data.firstName = this.profileForm.controls.firstName.value;
        data.lastName = this.profileForm.controls.lastName.value;
        data.dob = this.profileForm.controls.dob.value;
        data.phone = this.profileForm.controls.phone.value;
        data.gender = this.profileForm.controls.gender.value;
        data.province = this.profileForm.controls.provinceCode.value;
        data.district = this.profileForm.controls.districtCode.value;
        data.ward = this.profileForm.controls.wardCode.value;
        this.currentAccount.imageUrl = this.uploadedFiles[0];
        this.accountService.save(this.currentAccount).subscribe(
          () => {
            this.error = null;
            this.success = 'OK';
            // eslint-disable-next-line
            console.log('Udate hình: ', this.uploadedFiles);
          },
          () => {
            this.success = null;
            this.error = 'ERROR';
          }
        );
        this.userService
          .update(data)
          .subscribe(
            () => this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Dã cập nhật thành công thông tin!!' }),
            err => this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: err.error.title })
          );
      }
    });
  }
}
