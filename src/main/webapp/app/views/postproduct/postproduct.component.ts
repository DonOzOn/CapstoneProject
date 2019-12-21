import { UserService } from './../../core/user/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { OnInit, Component, ElementRef, Renderer } from '@angular/core';
import { AddressService } from 'app/core/address/address.service';
import { FormBuilder, Validators } from '@angular/forms';
import { SelectItem, ConfirmationService, MessageService } from 'primeng/api';
import { DirectionService } from 'app/core/direction/direction.service';
import { LegalStatusService } from 'app/core/legal-status/legal-status.service';
import { UtilitiesService } from 'app/core/utilities/utilities.service';
import { JhiAlertService } from 'ng-jhipster';
import { ProductPostTypeService } from 'app/core/product-type/product-type.service';
import { ProductPost } from 'app/core/post/model/product-post.model';
import { PostService } from 'app/core/post/post.service';
import { PostRequest } from 'app/core/post/model/postRequest.model copy';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { IUser } from 'app/core/user/user.model';

@Component({
  selector: 'app-postproduct',
  templateUrl: './postproduct.component.html',
  styleUrls: ['./postproduct.component.scss'],
  providers: [ConfirmationService, MessageService]
})
export class PostproductComponent implements OnInit {
  /*  Item select button  */
  selectedType: string;
  types: SelectItem[];
  selectedUtility: string[] = [];
  isUploadedFile = false;
  text1 = null;
  formAddress = this.fb.group({
    address: [null, Validators.required],
    provinceCode: [null, Validators.required],
    districtCode: [null, Validators.required],
    wardCode: [null, Validators.required]
  });
  /*  List provinces, district, ward, direction */
  listProvinces = [];
  listDistrict = [];
  listWard = [];
  listDirection = [];
  listUtilities = [];
  listLegalStatus = [];
  /* product post */
  productPost: ProductPost;
  account: Account;
  user: IUser;
  /*  List product type and product type child  */
  listProductTypeChild: [];
  listProductType: [];
  uploadedFiles: any[] = [];
  countContent: any = 0;
  listUtilitiesSelected = [];
  listImageName = [];
  /*  Form product post */
  productPostForm = this.fb.group({
    projectName: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    type: [null, Validators.required],
    address: [null],
    provinceCode: [null, Validators.required],
    districtCode: [null, Validators.required],
    wardCode: [null, Validators.required],
    productTypeID: [null, Validators.required],
    productTypeChildID: [null, Validators.required],
    // eslint-disable-next-line
    price: [null, [Validators.required, Validators.maxLength(15), Validators.pattern('^[0-9]*$')]],
    area: [null, [Validators.required, Validators.maxLength(5), Validators.pattern('^[0-9]*$')]],
    directionID: [null, Validators.required],
    legalStatusID: [null, Validators.required],
    projectPostTitle: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(100)]],
    // eslint-disable-next-line
    numFloor: [null, [Validators.required, Validators.max(200), Validators.pattern('^[0-9]*$')]],
    // eslint-disable-next-line
    numBathroom: [null, [Validators.required, Validators.max(200), Validators.pattern('^[0-9]*$')]],
    // eslint-disable-next-line
    numBedroom: [null, [Validators.required, Validators.max(20), Validators.maxLength(11), Validators.pattern('^[0-9]*$')]],
    content: [this.text1, Validators.maxLength(255)],
    utilities: [null]
  });
  post: PostRequest = new PostRequest();
  constructor(
    private addressService: AddressService,
    private directionService: DirectionService,
    private legalStatusService: LegalStatusService,
    private utilitiesService: UtilitiesService,
    private fb: FormBuilder,
    private productPostTypeService: ProductPostTypeService,
    private elementRef: ElementRef,
    private renderer: Renderer,
    private confirmationService: ConfirmationService,
    private alertService: JhiAlertService,
    private router: Router,
    private postService: PostService,
    private accountService: AccountService,
    private userService: UserService,
    private messageService: MessageService
  ) {
    this.types = [{ label: 'Mua bán', value: '1' }, { label: 'Cho Thuê', value: '2' }];
  }

  ngOnInit() {
    this.getProvince();
    this.getProductType();
    this.getDirection();
    this.getLegalStatus();
    this.getUtility();
    this.selectedType = this.types[0].value;
    // this.selectedType = 'Mua bán';
  }

  // eslint-disable-next-line @typescript-eslint/tslint/config
  ngAfterViewInit(): void {
    this.renderer.selectRootElement('#projectName').focus();
    // this.renderer.invokeElementMethod(this.elementRef.nativeElement.querySelector('#projectName'), 'focus', []);
  }

  /*  add picture to list */
  onUpload(event, fileUpload) {
    const listFile = [];
    for (const file of event.files) {
      listFile.push(file);
    }
    listFile.forEach(element => {
      this.postService.upload(element).subscribe(
        res => {
          this.uploadedFiles.push(res.body);
          this.isUploadedFile = true;
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Dã tải ảnh thành công!!' });
        },
        (err: HttpErrorResponse) => {
          this.isUploadedFile = false;
          this.messageService.add({ severity: 'error', summary: 'Lỗi!', detail: 'Tải ảnh thất bại!!' });
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
  }
  /* get ward when select distric */
  selectedDistrict() {
    if (this.formAddress.value.districtCode != null) {
      this.addressService.filterWard(this.formAddress.value.districtCode).subscribe((res: any) => {
        this.listWard = res.body;
        this.formAddress.controls.wardCode.reset();
      });
    }
  }

  /* get district when select distric */
  selectedProvince() {
    if (this.formAddress.value.provinceCode != null) {
      this.addressService.filterDistrict(this.formAddress.value.provinceCode).subscribe((res: any) => {
        this.listDistrict = res.body;
        this.formAddress.controls.districtCode.reset();
        this.formAddress.controls.wardCode.reset();
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

  /*  get all product type */
  getProductType() {
    this.productPostTypeService.filterType().subscribe((res: any) => {
      this.listProductType = res.body;
      this.selectedProductTypeChild();
    });
  }

  /* get product type child when select product type */
  selectedProductTypeChild() {
    if (this.productPostForm.value.productTypeID != null) {
      this.productPostTypeService.filterTypeChild(this.productPostForm.value.productTypeID).subscribe((res: any) => {
        this.listProductTypeChild = res.body;
        this.productPostForm.controls.productTypeChildID.reset();
      });
    }
  }

  /**
   * Get list direction
   */
  getDirection() {
    this.directionService.getDirection().subscribe((res: any) => {
      this.listDirection = res.body;
    });
  }

  /**
   * Get list legal status
   */
  getLegalStatus() {
    this.legalStatusService.getLegalStatus().subscribe((res: any) => {
      this.listLegalStatus = res.body;
    });
  }

  /**
   * Count content length
   */
  countContentNumber() {
    if (this.text1 != null) {
      this.countContent = this.text1;
      return true;
    } else {
      this.countContent = 0;
      return false;
    }
  }

  /**
   * Get list utility
   */
  getUtility() {
    this.utilitiesService.getUtilities().subscribe((res: any) => {
      this.listUtilities = res.body;
    });
  }

  /**
   * checkItemChecked
   */
  checkItemChecked() {
    // eslint-disable-next-line
    console.log('checked value', this.listUtilitiesSelected);
  }

  /**
   * submit form
   */
  postProduct() {
    if (!this.isUploadedFile) {
      this.messageService.add({ severity: 'warn', summary: 'Cảnh báo!', detail: 'Hãy tải ảnh lên trước' });
    } else {
      this.productPostForm.controls.utilities.setValue(this.listUtilitiesSelected);
      this.productPostForm.controls.type.setValue(this.selectedType);
      this.accountService.identity().subscribe((account: Account) => {
        this.account = account;
      });

      this.userService.find(this.account.login).subscribe((userAuthen: IUser) => {
        this.user = userAuthen;
        const product = {
          price: this.productPostForm.controls.price.value,
          area: this.productPostForm.controls.area.value,
          direction: this.productPostForm.controls.directionID.value,
          legalStatus: this.productPostForm.controls.legalStatusID.value,
          numberFloor: this.productPostForm.controls.numFloor.value,
          numberBathroom: this.productPostForm.controls.numBathroom.value,
          numberBedroom: this.productPostForm.controls.numBedroom.value,
          productTypeChild: this.productPostForm.controls.productTypeChildID.value,
          productType: this.productPostForm.controls.productTypeID.value,
          utilities: this.productPostForm.controls.utilities.value,
          status: true
        };
        // eslint-disable-next-line
        console.log('user id: ', this.user);
        const productPost = {
          user: this.user.id,
          projectName: this.productPostForm.controls.projectName.value,
          productPostType: this.productPostForm.controls.type.value,
          productPostTitle: this.productPostForm.controls.projectPostTitle.value,
          totalLike: null,
          typeDeal: null,
          totalReport: null,
          totalShare: null,
          ward: this.formAddress.controls.wardCode.value,
          province: this.formAddress.controls.provinceCode.value,
          district: this.formAddress.controls.districtCode.value,
          address: this.formAddress.controls.address.value,
          content: this.productPostForm.controls.content.value,
          shortDescription: this.productPostForm.controls.content.value.substr(0, 51),
          product: null,
          status: true
        };
        const image = {
          img1: this.uploadedFiles[0],
          img2: this.uploadedFiles[1],
          img3: this.uploadedFiles[2],
          img4: this.uploadedFiles[3],
          img5: this.uploadedFiles[4],
          img6: this.uploadedFiles[5],
          img7: this.uploadedFiles[6],
          img8: this.uploadedFiles[7],
          img9: this.uploadedFiles[8],
          img10: this.uploadedFiles[9],
          status: true
        };
        const usingImage = {
          image: null,
          usingType: null,
          productPost: null,
          status: true
        };
        this.post.productRequestDTO = product;
        this.post.productPostRequestDTO = productPost;
        this.post.imageDTO = image;
        this.post.usingImageRequestDTO = usingImage;
        this.post.listImage = this.uploadedFiles;
        this.confirmationService.confirm({
          message: 'Bạn có chắc chắn muốn tạo bài đăng này?',
          accept: () => {
            this.alertService.clear();
            this.postService.create(this.post).subscribe(
              // eslint-disable-next-line
              (res: any) => this.router.navigate(['manage-product']),
              (err: HttpErrorResponse) => this.alertService.error(err.error.title)
            );
          }
        });
      });
    }
  }
}
