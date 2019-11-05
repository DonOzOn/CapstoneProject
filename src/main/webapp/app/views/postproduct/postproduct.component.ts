import { Router } from '@angular/router';
import { OnInit, Component, ElementRef, Renderer } from '@angular/core';
import { AddressService } from 'app/core/address/address.service';
import { FormBuilder, Validators } from '@angular/forms';
import { SelectItem, ConfirmationService } from 'primeng/api';
import { DirectionService } from 'app/core/direction/direction.service';
import { LegalStatusService } from 'app/core/legal-status/legal-status.service';
import { UtilitiesService } from 'app/core/utilities/utilities.service';
import { ProductPostService } from 'app/core/product-post/product-post.service';
import { IProductPost, ProductPost } from 'app/core/product-post/product-post.model';
import { JhiAlertService } from 'ng-jhipster';
import { ProductPostTypeService } from 'app/core/product-type/product-type.service';

@Component({
  selector: 'app-postproduct',
  templateUrl: './postproduct.component.html',
  styleUrls: ['./postproduct.component.scss']
})
export class PostproductComponent implements OnInit {
  /*  Item select button  */
  selectedType: string;
  types: SelectItem[];
  selectedUtility: string[] = [];
  text1 = '<div>Hello!</div><div>Welcom to BDS</div><div><br></div>';
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
  /*  List product type and product type child  */
  listProductTypeChild: [];
  listProductType: [];
  uploadedFiles: any[] = [];
  countContent: any = 0;
  listUtilitiesSelected = [];
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
    price: [null, [Validators.maxLength(50), Validators.pattern('^[0-9]*$')]],
    area: [null, [Validators.maxLength(50), Validators.pattern('^[0-9]*$')]],
    directionID: [null],
    legalStatusID: [null, Validators.required],
    projectPostTitle: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(100)]],
    content: [this.text1, Validators.maxLength(255)],
    utilities: [null]
  });
  constructor(
    private addressService: AddressService,
    private directionService: DirectionService,
    private legalStatusService: LegalStatusService,
    private utilitiesService: UtilitiesService,
    private fb: FormBuilder,
    private productPostTypeService: ProductPostTypeService,
    private elementRef: ElementRef,
    private renderer: Renderer,
    private productPostService: ProductPostService,
    private confirmationService: ConfirmationService,
    private alertService: JhiAlertService,
    private router: Router
  ) {
    this.types = [
      { label: 'Mua bán', value: '1' },
      { label: 'Cho Thuê', value: '2' },
    ];
  }

  ngOnInit() {
    this.getProvince();
    this.getProductType();
    this.getDirection();
    this.getLegalStatus();
    this.getUtility();
  }
  /*  add picture to list */
  onUpload(event) {
    for (const file of event.files) {
      this.uploadedFiles.push(file);
    }
  }

  /* get ward when select distric */
  selectedDistrict() {
    if (this.formAddress.value.districtCode != null) {
      this.addressService.filterWard(this.formAddress.value.districtCode).subscribe((res: any) => {
        this.listWard = res.body;
        this.productPostForm.controls.wardCode.reset();
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

  /**
   * submit form
   */
  postProduct() {
    // eslint-disable-next-line
    console.log('do nothing');
    this.confirmationService.confirm({
      message: 'Bạn có chắc chắn muốn tạo bài đăng này?',
      accept: () => {
        const data: IProductPost = this.productPostForm.getRawValue();
        this.alertService.clear();
        this.productPostService
          .create(data)
          .subscribe(() => this.router.navigate(['']), err => this.alertService.error(err.error.title));
      }
    });
  }
  }
