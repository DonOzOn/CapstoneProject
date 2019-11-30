export interface INews {
  id?: any;
  title?: String;
  decription?: String;
  content?: String;
  imageUrl?: String;
  status?: boolean;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}

export class News implements INews {
  constructor(
    public id?: any,
    public title?: String,
    public decription?: String,
    public content?: String,
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
    this.imageUrl = imageUrl ? imageUrl : null;
    this.status = status ? status : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
