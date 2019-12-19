import { Component, OnInit, ElementRef, Renderer } from '@angular/core';
import { SelectItem, ConfirmationService, MessageService } from 'primeng/api';
import { CarService } from 'app/core/service/car.service';
import { Validators, FormBuilder } from '@angular/forms';
import { ProductPost } from 'app/core/post/model/product-post.model';
import { IUser } from 'app/core/user/user.model';
import { PostRespone } from 'app/core/post/model/postRespone.model';
import { AddressService } from 'app/core/address/address.service';
import { DirectionService } from 'app/core/direction/direction.service';
import { LegalStatusService } from 'app/core/legal-status/legal-status.service';
import { UtilitiesService } from 'app/core/utilities/utilities.service';
import { ProductPostTypeService } from 'app/core/product-type/product-type.service';
import { JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';
import { PostService } from 'app/core/post/post.service';
import { AccountService } from 'app/core/auth/account.service';
import { UserService } from 'app/core/user/user.service';
import { Account } from 'app/core/user/account.model';
import { HttpErrorResponse } from '@angular/common/http';
import { PostRequest } from 'app/core/post/model/postRequest.model copy';
import { SERVER_API_URL } from 'app/app.constants';

export interface Car {
  vin: any;
  year: any;
  brand: any;
  color: any;
}

@Component({
  selector: 'app-manageproductpost',
  templateUrl: './manageproductpost.component.html',
  styleUrls: ['./manageproductpost.component.scss'],
  providers: [ConfirmationService, MessageService]
})
export class ManageproductpostComponent implements OnInit {
  imageUrl = SERVER_API_URL + '/api/upload/files/';
  currentAccount: Account;
  currentUser: IUser;
  /*  Item select button  */
  selectedType: string;
  types: SelectItem[];
  selectedUtility: string[] = [];
  isUploadedFile = false;
  text1 = '<div>Hello!</div><div>Chào mừng tới BDS</div><div><br></div>';
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
    provinceCode: [null],
    districtCode: [null],
    wardCode: [null],
    productTypeID: [null, Validators.required],
    productTypeChildID: [null, Validators.required],
    // eslint-disable-next-line
    price: [null, [Validators.maxLength(15), Validators.pattern('^[0-9]*$')]],
    area: [null, [Validators.maxLength(5), Validators.pattern('^[0-9]*$')]],
    directionID: [null],
    legalStatusID: [null, Validators.required],
    projectPostTitle: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(100)]],
    // eslint-disable-next-line
    numFloor: [null, [Validators.maxLength(11), Validators.max(200), Validators.pattern('^[0-9]*$')]],
    // eslint-disable-next-line
    numBathroom: [null, [Validators.maxLength(11), Validators.max(200), Validators.pattern('^[0-9]*$')]],
    // eslint-disable-next-line
    numBedroom: [null, [Validators.maxLength(11), Validators.max(20), Validators.pattern('^[0-9]*$')]],
    content: [null],
    utilities: [null]
  });

  post: PostRequest = new PostRequest();

  posts: PostRespone[] = [];

  selectedPost: PostRespone;

  cars: Car[];

  selectedCar: Car;

  displayDialog: boolean;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;
  constructor(
    private carService: CarService,
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
    this.types = [{ label: 'Mua bán', value: 1 }, { label: 'Cho Thuê', value: 2 }];
  }

  ngOnInit() {
    // this.selectedType = 'Mua bán';
    this.accountService.identity().subscribe((account: Account) => {
      this.currentAccount = account;
      this.userService.find(this.currentAccount.login).subscribe((userAuthen: IUser) => {
        this.currentUser = userAuthen;
        this.getListPostProduct();
      });
    });
    this.getlistCar();
    this.sortOptions = [{ label: 'Cũ nhất', value: 1 }, { label: 'Mới nhất', value: 2 }];
    this.getProvince();
    this.getProductType();
    this.getDirection();
    this.getLegalStatus();
    this.getUtility();
  }

  getlistCar() {
    this.carService.getListCar().subscribe(res => {
      this.cars = res.data.rows;
    });
  }

  /**
   * delete post
   * @param event
   * @param post
   */
  deleteSelectPostproduct(id: any) {
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn xóa bài đăng này?',
      accept: () => {
        this.alertService.clear();
        this.postService.delete(id).subscribe(() => {
          // eslint-disable-next-line
          console.log('postId : ', id);
          this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã xóa bài đăng thành công!!' });
          this.getListPostProduct();
        });
      }
    });
  }

  selectPostproduct(event: Event, post: PostRespone) {
    this.listUtilitiesSelected = [];
    this.selectedPost = post;
    this.displayDialog = true;
    this.selectedType = this.selectedPost.productPostResponseDTO.productPostType.id;
    this.text1 = this.selectedPost.productPostResponseDTO.content;
    this.productPostForm.controls.projectName.setValue(this.selectedPost.productPostResponseDTO.projectName);
    this.productPostForm.controls.content.setValue(this.selectedPost.productPostResponseDTO.content);
    this.text1 = this.productPostForm.controls.content.value;
    this.formAddress.controls.address.setValue(this.selectedPost.productPostResponseDTO.address);
    this.formAddress.controls.provinceCode.setValue(this.selectedPost.productPostResponseDTO.province.code);
    if (this.formAddress.value.provinceCode != null) {
      this.addressService.filterDistrict(this.formAddress.value.provinceCode).subscribe((res: any) => {
        this.listDistrict = res.body;
      });
    }
    this.formAddress.controls.districtCode.setValue(this.selectedPost.productPostResponseDTO.district.code);
    if (this.formAddress.value.districtCode != null) {
      this.addressService.filterWard(this.formAddress.value.districtCode).subscribe((res: any) => {
        this.listWard = res.body;
      });
    }
    this.formAddress.controls.wardCode.setValue(this.selectedPost.productPostResponseDTO.ward.code);
    this.productPostForm.controls.productTypeID.setValue(this.selectedPost.productResponseDTO.productType.id);
    if (this.productPostForm.value.productTypeID != null) {
      this.productPostTypeService.filterTypeChild(this.productPostForm.value.productTypeID).subscribe((res: any) => {
        this.listProductTypeChild = res.body;
      });
    }
    this.productPostForm.controls.productTypeChildID.setValue(this.selectedPost.productResponseDTO.productTypeChild.id);
    this.productPostForm.controls.price.setValue(this.selectedPost.productResponseDTO.price);
    this.productPostForm.controls.area.setValue(this.selectedPost.productResponseDTO.area);
    this.productPostForm.controls.directionID.setValue(this.selectedPost.productResponseDTO.direction.id);
    this.productPostForm.controls.legalStatusID.setValue(this.selectedPost.productResponseDTO.legalStatus.id);
    this.productPostForm.controls.projectPostTitle.setValue(this.selectedPost.productPostResponseDTO.productPostTitle);
    this.productPostForm.controls.numFloor.setValue(this.selectedPost.productResponseDTO.numberFloor);
    this.productPostForm.controls.numBathroom.setValue(this.selectedPost.productResponseDTO.numberBathroom);
    this.productPostForm.controls.numBedroom.setValue(this.selectedPost.productResponseDTO.numberBedroom);
    this.productPostForm.controls.utilities.setValue(this.selectedPost.productResponseDTO.utilities);
    this.productPostForm.controls.utilities.value.forEach(element => {
      this.listUtilitiesSelected.push(element.id + '');
    });
    event.preventDefault();
  }

  loadData(event) {
    event.first = true;
    event.rows = 10;
  }

  // selectPostproduct(event: Event, car: Car) {
  //   this.selectedCar = car;
  //   this.displayDialog = true;
  //   event.preventDefault();
  // }
  /**
   * get all post product
   */
  // eslint-disable-next-line
  getListPostProduct() {
    this.postService.listAllByUserID(this.currentUser.id).subscribe(res => {
      this.posts = res.body;
      // eslint-disable-next-line @typescript-eslint/tslint/config
      // eslint-disable-next-line no-empty
      for (let i = 0; i <= this.posts.length; i++) {
        // eslint-disable-next-line @typescript-eslint/tslint/config
        this.uploadedFiles.push(this.posts[i].imageDTO.img1);
        this.uploadedFiles.push(this.posts[i].imageDTO.img2);
        this.uploadedFiles.push(this.posts[i].imageDTO.img3);
        this.uploadedFiles.push(this.posts[i].imageDTO.img4);
        this.uploadedFiles.push(this.posts[i].imageDTO.img5);
        this.uploadedFiles.push(this.posts[i].imageDTO.img6);
        this.uploadedFiles.push(this.posts[i].imageDTO.img7);
        this.uploadedFiles.push(this.posts[i].imageDTO.img8);
        this.uploadedFiles.push(this.posts[i].imageDTO.img9);
        this.uploadedFiles.push(this.posts[i].imageDTO.img10);
      }
      // eslint-disable-next-line
      console.log('not sort : ', this.posts);
      this.posts = this.posts.sort((a: any, b: any) => {
        // eslint-disable-next-line
        console.log('sort : ');
        return new Date(b.productPostResponseDTO.createdDate).valueOf() - new Date(a.productPostResponseDTO.createdDate).valueOf();
      });
    });
  }
  onSortChange(event: { value: any }) {
    // eslint-disable-next-line
    console.log('key : ', this.sortKey);
    const value = event.value;
    switch (value) {
      case 1: {
        this.posts.sort(function(obj1: any, obj2: any) {
          return new Date(obj1.productPostResponseDTO.createdDate).valueOf() - new Date(obj2.productPostResponseDTO.createdDate).valueOf();
        });
        break;
      }
      case 2: {
        this.posts.sort(function(obj1: any, obj2: any) {
          return new Date(obj2.productPostResponseDTO.createdDate).valueOf() - new Date(obj1.productPostResponseDTO.createdDate).valueOf();
        });
        break;
      }

      default: {
        break;
      }
    }
  }

  onDialogHide() {
    this.redirectTo('/manage-product');
    this.selectedCar = null;
  }

  onShowDialog() {
    this.selectedCar = null;
  }
  /*  add picture to list */
  onUpload(event, fileUpload) {
    this.uploadedFiles = [];
    // eslint-disable-next-line
    console.log('da qua day');
    const listFile = [];
    for (const file of event.files) {
      listFile.push(file);
    }
    listFile.forEach(element => {
      this.postService.upload(element).subscribe(
        res => {
          // eslint-disable-next-line
          console.log('element', element);
          this.uploadedFiles.push(res.body);
          // eslint-disable-next-line
          console.log('res-body', res.body);
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
    if (this.productPostForm.value.content.length != null) {
      this.countContent = this.productPostForm.value.content.length;
    } else {
      this.countContent = 0;
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

  redirectTo(uri: string) {
    this.router.navigateByUrl('/usermanage', { skipLocationChange: true }).then(() => this.router.navigate([uri]));
  }

  /**
   * submit form
   */
  postProduct() {
    this.productPostForm.controls.utilities.setValue(this.listUtilitiesSelected);
    this.productPostForm.controls.type.setValue(this.selectedType);
    this.accountService.identity().subscribe((account: Account) => {
      this.account = account;
    });
    const product = {
      id: this.selectedPost.productResponseDTO.id,
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

    const productPost = {
      id: this.selectedPost.productPostResponseDTO.id,
      user: this.selectedPost.productPostResponseDTO.user.id,
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
      id: this.selectedPost.imageDTO.id,
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
      id: this.selectedPost.usingImageResponseDTO.id,
      image: null,
      usingType: null,
      productPost: null,
      status: true
    };
    this.post.productRequestDTO = product;
    // eslint-disable-next-line
    console.log('this.post.productRequestDTO :', this.post.productRequestDTO);
    this.post.productPostRequestDTO = productPost;
    this.post.imageDTO = image;
    this.post.usingImageRequestDTO = usingImage;
    this.post.listImage = this.uploadedFiles;
    // eslint-disable-next-line
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn sửa bài đăng này?',
      accept: () => {
        this.alertService.clear();
        this.postService
          .update(this.post)
          // eslint-disable-next-line
          .subscribe(
            (res: any) => (
              this.getListPostProduct(),
              this.router.navigate(['manage-product']),
              (this.displayDialog = false),
              this.messageService.add({ severity: 'success', summary: 'Chúc mừng!', detail: 'Đã cập nhật bài đăng thành công!!' })
            ),
            (err: HttpErrorResponse) => this.alertService.error(err.error.title)
          );
        this.redirectTo('/manage-product');
      }
    });
  }
}
