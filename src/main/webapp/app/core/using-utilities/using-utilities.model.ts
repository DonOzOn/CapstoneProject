import { Utilities } from './../utilities/utilities.model';
import { Product } from '../product/product.model';

export interface IUsingUtilities {
    id?: any;
    product?: Product;
    utilities?: Utilities;
    status?: boolean;
    createdBy?: string;
    createdDate?: Date;
    lastModifiedBy?: string;
    lastModifiedDate?: Date;
}
export class UsingUtilities implements IUsingUtilities {
    constructor(
        public id?: any,
        public product?: Product,
        public utilities?: Utilities,
        public status?: boolean,
        public createdBy?: string,
        public createdDate?: Date,
        public lastModifiedBy?: string,
        public lastModifiedDate?: Date
    ) {
        this.id = id ? id : null;
        this.product = product ? product : null;
        this.utilities = utilities ? utilities : null;
        this.status = status ? status : null;
        this.createdBy = createdBy ? createdBy : null;
        this.createdDate = createdDate ? createdDate : null;
        this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
    }
}
