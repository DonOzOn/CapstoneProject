export interface IProvince {
    code?: string;
    name?: string;
    type?: string;
}

export class Province implements IProvince {
    constructor(public code?: string, public name?: string , public type?: string) {
        this.code = code ? code : null;
        this.name = name ? name : null;
        this.type = type ? type : null;
    }
}
