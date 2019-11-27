import { Product } from './product.model';
import { ProductPost } from './product-post.model';
import { Image } from './image.model';
import { UsingImage } from './using-image.model';

export interface IPostRespone {
  productResponseDTO?: Product;
  productPostResponseDTO?: ProductPost;
  imageDTO?: Image;
  usingImageResponseDTO?: UsingImage;
}
export class PostRespone implements IPostRespone {
  constructor(
    public productResponseDTO?: Product,
    public productPostResponseDTO?: ProductPost,
    public imageDTO?: Image,
    public usingImageResponseDTO?: UsingImage
  ) {
    this.productResponseDTO = productResponseDTO ? productResponseDTO : null;
    this.productPostResponseDTO = productPostResponseDTO ? productPostResponseDTO : null;
    this.imageDTO = imageDTO ? imageDTO : null;
    this.usingImageResponseDTO = usingImageResponseDTO ? usingImageResponseDTO : null;
  }
}
