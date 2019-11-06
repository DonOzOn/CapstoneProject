export interface IUtilities {
    id?: any;
    utilitiesName?: string;
}

export class Utilities implements IUtilities {
    constructor(public id?: any, public utilitiesName?: string ) {
        this.id = id ? id : null;
        this.utilitiesName = utilitiesName ? utilitiesName : null;
    }
}
