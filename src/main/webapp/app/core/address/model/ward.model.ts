export interface IWard {
    code?: string;
    name?: string;
}

export class Ward implements IWard {
    constructor(public code?: string, public name?: string) {
        this.code = code ? code : null;
        this.name = name ? name : null;
    }
}
