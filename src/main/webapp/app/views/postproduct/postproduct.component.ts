import { OnInit, Component, ElementRef, Renderer } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AddressService } from 'app/core/address/address.service';
import { FormBuilder, Validators } from '@angular/forms';
import { SelectItem } from 'primeng/api';
import { ProductPostTypeService } from 'app/core/product-post-type/product-post-type.service';

@Component({
  selector: 'app-postproduct',
  templateUrl: './postproduct.component.html',
  styleUrls: ['./postproduct.component.scss']
})
export class PostproductComponent implements OnInit {
  profileForm = new FormGroup({
    projectname: new FormControl(),
    type: new FormControl(),
    typeBDS: new FormControl(),
    title: new FormControl(),
    one: new FormControl(),
    two: new FormControl(),
    three: new FormControl(),
    four: new FormControl()
  });
  /*  Item select button  */
  selectedType: string;
  types: SelectItem[];
  formAddress = this.fb.group({
    address: [null, Validators.required],
    provinceCode: [null, Validators.required],
    districtCode: [null, Validators.required],
    wardCode: [null, Validators.required]
  });
  /*  List provinces, district, ward */
  listProvinces = [];
  listDistrict = [];
  listWard = [];
  /*  List product type and product type child  */
  listProductTypeChild: [];
  listProductType: [];
  text1 = '<div>Hello World!</div><div>PrimeNG <b>Editor</b> Rocks</div><div><br></div>';
  uploadedFiles: any[] = [];
  /*  Form product post */
  productPostForm = this.fb.group({
    projectName: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    name: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(50)]],
    type: [null, Validators.required],
    address: [null],
    provinceCode: [null],
    districtCode: [null],
    wardCode: [null],
    productTypeID: [null, Validators.required],
    productTypeChildID: [null, Validators.required],
    typeBDS: [null],
    projectname: [null],
    title: [null],
    one: [null],
    two: [null],
    three: [null],
    four: [null]
  });
  constructor(
    private addressService: AddressService,
    private fb: FormBuilder,
    private productPostTypeService: ProductPostTypeService,
    private elementRef: ElementRef,
    private renderer: Renderer,
  ) {
    this.types = [
      { label: 'Mua bán', value: '1' },
      { label: 'Cho Thuê', value: '2' },
    ];
  }

  ngOnInit() {
    this.getProvince();
    this.getProductType();
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
}
