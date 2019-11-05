export interface IProductTypeChild {
    id?: any;
    productTypeChildName?: string;
}

export class ProductTypeChild implements IProductTypeChild {
    constructor(public id?: any, public productTypeChildName?: string ) {
        this.id = id ? id : null;
        this.productTypeChildName = productTypeChildName ? productTypeChildName : null;
    }
}
