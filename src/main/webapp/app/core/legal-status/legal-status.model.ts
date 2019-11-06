export interface ILegalStatus {
    id?: any;
    legalStatusName?: string;
}

export class LegalStatus implements ILegalStatus {
    constructor(public id?: any, public legalStatusName?: string ) {
        this.id = id ? id : null;
        this.legalStatusName = legalStatusName ? legalStatusName : null;
    }
}
