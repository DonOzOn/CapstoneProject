import { IUser } from './../user/user.model';
import { Ward } from '../address/model/ward.model';
import { Province } from '../address/model/province.model';
import { District } from '../address/model/district.model';
import { Product } from '../product/product.model';
export interface IProductPost {
    id?: any;
    user?: IUser;
    projectName?: string;
    productPostType?: any;
    productPostTitle?: string;
    totalLike?: string;
    typeDeal?: string;
    totalReport?: string;
    totalShare?: string;
    ward?: Ward;
    province?: Province;
    district?: District;
    address?: string;
    shortDescription?: string;
    content?: string;
    product?: Product;
    status?: boolean;
    createdBy?: string;
    createdDate?: Date;
    lastModifiedBy?: string;
    lastModifiedDate?: Date;
}
export class ProductPost implements IProductPost {
    constructor(
        public id?: any,
        public name?: string,
        public startHour?: any,
        public endHour?: any,
        public breakStart?: any,
        public breakEnd?: any,
        public overtimeStart?: any,
        public overtimeEnd?: any,
        public status?: boolean
    ) {
        this.id = id ? id : null;
        this.name = name ? name : null;
        this.startHour = startHour ? startHour : null;
        this.endHour = endHour ? endHour : null;
        this.breakStart = breakStart ? breakStart : null;
        this.breakEnd = breakEnd ? breakEnd : null;
        this.overtimeStart = overtimeStart ? overtimeStart : null;
        this.overtimeEnd = overtimeEnd ? overtimeEnd : null;
        this.status = status ? status : null;
    }
}
