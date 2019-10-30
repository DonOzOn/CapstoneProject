export interface IProductType {
    id?: any;
    productTypeName?: string;
}

export class ProductType implements IProductType {
    constructor(public id?: any, public productTypeName?: string) {
        this.id = id ? id : null;
        this.productTypeName = productTypeName ? productTypeName : null;
    }
}
