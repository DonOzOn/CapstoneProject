export interface ILikedReview {
  id?: any;
  user?: any;
  review?: any;
  status?: boolean;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}
export class LikedReview implements ILikedReview {
  constructor(
    public id?: any,
    public user?: any,
    public review?: any,
    public status?: boolean,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.user = user ? user : null;
    this.review = review ? review : null;
    this.status = status ? status : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
