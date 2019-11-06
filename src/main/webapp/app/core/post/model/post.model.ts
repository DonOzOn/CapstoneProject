import { Product } from './product.model';
import { ProductPost } from './product-post.model';
import { Image } from './image.model';
import { UsingImage } from './using-image.model';

export interface IPost {
    product?: Product;
    productPost?: ProductPost;
    image?: Image;
    usingImage?: UsingImage;
}
export class Post implements IPost {
    constructor(
        public product?: Product,
        public productPost?: ProductPost,
        public image?: Image,
        public usingImage?: UsingImage,
    ) {
        this.product = product ? product : null;
        this.productPost = productPost ? productPost : null;
        this.image = image ? image : null;
        this.usingImage = usingImage ? usingImage : null;
    }
}
