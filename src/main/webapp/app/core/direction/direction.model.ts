export interface IDirection {
    id?: any;
    directionName?: string;
}

export class Direction implements IDirection {
    constructor(public id?: any, public directionName?: string ) {
        this.id = id ? id : null;
        this.directionName = directionName ? directionName : null;
    }
}
