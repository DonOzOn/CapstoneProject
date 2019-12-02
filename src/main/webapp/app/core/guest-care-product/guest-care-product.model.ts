export interface IGuestCareProduct {
  id?: any;
  mess?: String;
  phone?: String;
  email?: String;
  name?: String;
  user?: any;
  productPost?: any;
  status?: boolean;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}

export class GuestCareProduct implements IGuestCareProduct {
  constructor(
    public id?: any,
    public mess?: String,
    public phone?: String,
    public email?: String,
    public name?: String,
    public user?: any,
    public productPost?: any,
    public status?: boolean,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.mess = mess ? mess : null;
    this.phone = phone ? phone : null;
    this.email = email ? email : null;
    this.name = name ? name : null;
    this.user = user ? user : null;
    this.productPost = productPost ? productPost : null;
    this.status = status ? status : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
