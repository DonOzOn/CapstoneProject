export interface IPar {
  id?: any;
  name_par?: String;
}

export class Par implements IPar {
  constructor(public id?: any, public name_par?: string) {
    this.id = id ? id : null;
    this.name_par = name_par ? name_par : null;
  }
}
