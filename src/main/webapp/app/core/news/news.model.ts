export interface INews {
  id?: any;
  title?: String;
  decription?: String;
  content?: String;
  status?: boolean;
}

export class News implements INews {
  constructor(public id?: any, public title?: string, public decription?: string, public content?: string, public status?: boolean) {
    this.id = id ? id : null;
    this.title = title ? title : null;
    this.decription = decription ? decription : null;
    this.content = content ? content : null;
    this.status = status ? status : null;
  }
}
