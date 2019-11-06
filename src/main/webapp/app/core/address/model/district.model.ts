export interface IDistrict {
    code?: string;
    name?: string;
}

export class District implements IDistrict {
    constructor(public code?: string, public name?: string) {
        this.code = code ? code : null;
        this.name = name ? name : null;
    }
}
