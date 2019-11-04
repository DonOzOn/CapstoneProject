export interface IProductPost {
    id?: any;
    name?: string;
    startHour?: any;
    endHour?: any;
    breakStart?: any;
    breakEnd?: any;
    overtimeStart?: any;
    overtimeEnd?: any;
    status?: boolean;
}
export class ProductPost implements IProductPost {
    constructor(
        public id?: any,
        public name?: string,
        public startHour?: any,
        public endHour?: any,
        public breakStart?: any,
        public breakEnd?: any,
        public overtimeStart?: any,
        public overtimeEnd?: any,
        public status?: boolean
    ) {
        this.id = id ? id : null;
        this.name = name ? name : null;
        this.startHour = startHour ? startHour : null;
        this.endHour = endHour ? endHour : null;
        this.breakStart = breakStart ? breakStart : null;
        this.breakEnd = breakEnd ? breakEnd : null;
        this.overtimeStart = overtimeStart ? overtimeStart : null;
        this.overtimeEnd = overtimeEnd ? overtimeEnd : null;
        this.status = status ? status : null;
    }
}
