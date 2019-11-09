import { Utilities } from './../../utilities/utilities.model';
import { Direction } from 'app/core/direction/direction.model';
import { LegalStatus } from 'app/core/legal-status/legal-status.model';
import { ProductTypeChild } from 'app/core/product-type/model/product-type-child.model';
import { ProductType } from 'app/core/product-type/model/product-type.model';

export interface IProduct {
    id?: any;
    price?: string;
    area?: string;
    direction?: Direction;
    legalStatus?: LegalStatus;
    numberFloor?: any;
    numberBathroom?: any;
    numberBedroom?: any;
    productTypeChild?: ProductTypeChild;
    productType?: ProductType;
    utilities?: any;
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
        public direction?: Direction,
        public legalStatus?: LegalStatus,
        public numberFloor?: any,
        public numberBathroom?: any,
        public numberBedroom?: any,
        public productTypeChild?: ProductTypeChild,
        public productType?: ProductType,
        public utilities?: any,
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
        this.utilities = utilities ? utilities : null;
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
