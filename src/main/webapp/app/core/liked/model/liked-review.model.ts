export interface ILikedReview {
  id?: any;
  img1?: string;
  img2?: string;
  img3?: string;
  img4?: string;
  img5?: string;
  img6?: string;
  img7?: string;
  img8?: string;
  img9?: string;
  img10?: string;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}
export class LikedReview implements ILikedReview {
  constructor(
    public id?: any,
    public img1?: string,
    public img2?: string,
    public img3?: string,
    public img4?: string,
    public img5?: string,
    public img6?: string,
    public img7?: string,
    public img8?: string,
    public img9?: string,
    public img10?: string,
    public status?: boolean,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.img1 = img1 ? img1 : null;
    this.img2 = img2 ? img2 : null;
    this.img3 = img3 ? img3 : null;
    this.img4 = img4 ? img4 : null;
    this.img5 = img5 ? img5 : null;
    this.img6 = img6 ? img6 : null;
    this.img7 = img7 ? img7 : null;
    this.img8 = img8 ? img8 : null;
    this.img9 = img9 ? img9 : null;
    this.img10 = img10 ? img10 : null;
    this.status = status ? status : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
