export interface INotification {
  id?: any;
  user?: any;
  content?: String;
  type?: String;
  status?: boolean;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}

export class Notification implements INotification {
  constructor(
    public id?: any,
    public user?: any,
    public content?: String,
    public type?: String,
    public status?: boolean,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.content = content ? content : null;
    this.type = type ? type : null;
    this.user = user ? user : null;
    this.status = status ? status : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
