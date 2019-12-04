export interface INotification {
  id?: any;
  userSend?: any;
  userReceive?: any;
  content?: String;
  type?: Number;
  title?: String;
  status?: boolean;
  createdBy?: string;
  createdDate?: Date;
  lastModifiedBy?: string;
  lastModifiedDate?: Date;
}

export class Notification implements INotification {
  constructor(
    public id?: any,
    public userSend?: any,
    public userReceive?: any,
    public content?: String,
    public title?: String,
    public type?: Number,
    public status?: boolean,
    public createdBy?: string,
    public createdDate?: Date,
    public lastModifiedBy?: string,
    public lastModifiedDate?: Date
  ) {
    this.id = id ? id : null;
    this.content = content ? content : null;
    this.type = type ? type : null;
    this.userSend = userSend ? userSend : null;
    this.userReceive = userReceive ? userReceive : null;
    this.title = title ? title : null;
    this.status = status ? status : null;
    this.createdBy = createdBy ? createdBy : null;
    this.createdDate = createdDate ? createdDate : null;
    this.lastModifiedBy = lastModifiedBy ? lastModifiedBy : null;
    this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
  }
}
