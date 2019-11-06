import { IUser } from 'app/core/user/user.model';
import { Ward } from 'app/core/address/model/ward.model';
import { Province } from 'app/core/address/model/province.model';
import { District } from 'app/core/address/model/district.model';
import { Product } from './product.model';

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
        public user?: IUser,
        public projectName?: string,
        public productPostType?: any,
        public productPostTitle?: string,
        public totalLike?: string,
        public typeDeal?: string,
        public totalReport?: string,
        public totalShare?: string,
        public ward?: Ward,
        public province?: Province,
        public district?: District,
        public address?: string,
        public shortDescription?: string,
        public content?: string,
        public product?: Product,
        public status?: boolean,
        public createdBy?: string,
        public createdDate?: Date,
        public lastModifiedBy?: string,
        public lastModifiedDate?: Date
   ) {
        this.id = id ? id : null;
        this.user = user ? user : null;
        this.projectName = projectName ? projectName : null;
        this.productPostType = productPostType ? productPostType : null;
        this.productPostTitle = productPostTitle ? productPostTitle : null;
        this.totalLike = totalLike ? totalLike : null;
        this.typeDeal = typeDeal ? typeDeal : null;
        this.totalReport = totalReport ? totalReport : null;
        this.totalShare = totalShare ? totalShare : null;
        this.ward = ward ? ward : null;
        this.province = province ? province : null;
        this.district = district ? district : null;
        this.address = address ? address : null;
        this.product = product ? product : null;
        this.content = content ? content : null;
        this.status = status ? status : null;
        this.createdBy = createdBy ? createdBy : null;
        this.createdDate = createdDate ? createdDate : null;
        this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
    }
}
