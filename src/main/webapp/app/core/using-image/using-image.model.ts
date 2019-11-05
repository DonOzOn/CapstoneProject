import { Image } from '../image/image.model';
import { ProductPost } from '../product-post/product-post.model';

export interface IUsingImage {
    id?: any;
    image?: Image;
    usingType?: string;
    productPost?: ProductPost;
    status?: boolean;
    createdBy?: string;
    createdDate?: Date;
    lastModifiedBy?: string;
    lastModifiedDate?: Date;
}
export class UsingImage implements IUsingImage {
    constructor(
        public id?: any,
        public image?: Image,
        public usingType?: string,
        public productPost?: ProductPost,
        public status?: boolean,
        public createdBy?: string,
        public createdDate?: Date,
        public lastModifiedBy?: string,
        public lastModifiedDate?: Date
    ) {
        this.id = id ? id : null;
        this.image = image ? image : null;
        this.usingType = usingType ? usingType : null;
        this.productPost = productPost ? productPost : null;
        this.status = status ? status : null;
        this.createdBy = createdBy ? createdBy : null;
        this.createdDate = createdDate ? createdDate : null;
        this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
    }
}
