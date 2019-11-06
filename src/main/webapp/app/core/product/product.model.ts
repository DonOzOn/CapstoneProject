import { ILegalStatus } from './../legal-status/legal-status.model';
import { IProductTypeChild, ProductTypeChild } from '../product-type/model/product-type-child.model';
import { IDirection } from './../direction/direction.model';
import { IProductType, ProductType } from '../product-type/model/product-type.model';
export interface IProduct {
    id?: any;
    price?: string;
    area?: string;
    direction?: IDirection;
    legalStatus?: ILegalStatus;
    numberFloor?: any;
    numberBathroom?: any;
    numberBedroom?: any;
    productTypeChild?: IProductTypeChild;
    productType?: IProductType;
    status?: boolean;
    createdBy?: string;
    createdDate?: Date;
    lastModifiedBy?: string;
    lastModifiedDate?: Date;
}
export class Product implements IProduct {
    constructor(
        public id?: any,
        public price?: string,
        public area?: string,
        public direction?: IDirection,
        public legalStatus?: ILegalStatus,
        public numberFloor?: boolean,
        public numberBathroom?: boolean,
        public numberBedroom?: Date,
        public productTypeChild?: ProductTypeChild,
        public productType?: ProductType,
        public status?: boolean,
        public createdBy?: string,
        public createdDate?: Date,
        public lastModifiedBy?: string,
        public lastModifiedDate?: Date
    ) {
        this.id = id ? id : null;
        this.price = price ? price : null;
        this.area = area ? area : null;
        this.direction = direction ? direction : null;
        this.legalStatus = legalStatus ? legalStatus : null;
        this.numberFloor = numberFloor ? numberFloor : null;
        this.numberBathroom = numberBathroom ? numberBathroom : null;
        this.numberBedroom = numberBedroom ? numberBedroom : null;
        this.productTypeChild = productTypeChild ? productTypeChild : null;
        this.productType = productType ? productType : null;
        this.status = status ? status : null;
        this.createdBy = createdBy ? createdBy : null;
        this.createdDate = createdDate ? createdDate : null;
        this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
    }
}
