export interface IReview {
  id?: any;
  title?: String;
  decription?: String;
  content?: String;
  imageUrl?: String;
  totalLike?: any;
  totalShare?: any;
  totalReport?: any;
  ward?: any;
  district?: any;
  province?: any;
  user?: any;
  type?: boolean;
  status?: boolean;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}

export class Review implements IReview {
  constructor(
    public id?: any,
    public title?: String,
    public decription?: String,
    public content?: String,
    public totalLike?: any,
    public totalShare?: any,
    public totalReport?: any,
    public ward?: any,
    public province?: any,
    public district?: any,
    public user?: any,
    public type?: boolean,
    public imageUrl?: String,
    public status?: boolean,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.title = title ? title : null;
    this.decription = decription ? decription : null;
    this.content = content ? content : null;
    this.totalLike = totalLike ? totalLike : null;
    this.totalShare = totalShare ? totalShare : null;
    this.totalReport = totalReport ? totalReport : null;
    this.ward = ward ? ward : null;
    this.province = province ? province : null;
    this.district = district ? district : null;
    this.type = type ? type : null;
    this.user = user ? user : null;
    this.imageUrl = imageUrl ? imageUrl : null;
    this.status = status ? status : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
