import { Product } from './product.model';
import { ProductPost } from './product-post.model';
import { Image } from './image.model';
import { UsingImage } from './using-image.model';

export interface IPost {
    productRequestDTO?: Product;
    productPostRequestDTO?: ProductPost;
    imageDTO?: Image;
    usingImageRequestDTO?: UsingImage;
}
export class Post implements IPost {
    constructor(
        public productRequestDTO?: Product,
        public productPostRequestDTO?: ProductPost,
        public imageDTO?: Image,
        public usingImageRequestDTO?: UsingImage,
    ) {
        this.productRequestDTO = productRequestDTO ? productRequestDTO : null;
        this.productPostRequestDTO = productPostRequestDTO ? productPostRequestDTO : null;
        this.imageDTO = imageDTO ? imageDTO : null;
        this.usingImageRequestDTO = usingImageRequestDTO ? usingImageRequestDTO : null;
    }
}
