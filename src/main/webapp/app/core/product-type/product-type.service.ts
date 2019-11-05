import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { IProductType } from './model/product-type.model';
import { IProductTypeChild } from './model/product-type-child.model';

@Injectable({
    providedIn: 'root'
})
export class ProductPostTypeService {
    public typeResourceUrl = SERVER_API_URL + 'api/product-type';
    public typechildResourceUrl = SERVER_API_URL + 'api/product-type-child';

    constructor(private http: HttpClient) {}

    filterTypeChild(productType: string): Observable<HttpResponse<IProductTypeChild[]>> {
        return this.http.get<IProductTypeChild[]>(this.typechildResourceUrl, { observe: 'response', params: { productType } });
    }
    filterType(): Observable<HttpResponse<IProductType[]>> {
        return this.http.get<IProductType[]>(this.typeResourceUrl, { observe: 'response' });
    }
}
