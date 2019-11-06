import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { IWard } from './model/ward.model';
import { IDistrict } from './model/district.model';
import { IProvince } from './model/province.model';
import { SERVER_API_URL } from 'app/app.constants';

@Injectable({
    providedIn: 'root'
})
export class AddressService {
    public wardsResourceUrl = SERVER_API_URL + 'api/wards';
    public districtsResourceUrl = SERVER_API_URL + 'api/districts';
    public provincesResourceUrl = SERVER_API_URL + 'api/provinces';
    constructor(private http: HttpClient) {}

    filterWard(districtCode: string): Observable<HttpResponse<IWard[]>> {
        return this.http.get<IWard[]>(this.wardsResourceUrl, { observe: 'response', params: { districtCode } });
    }
    filterDistrict(provinceCode: string): Observable<HttpResponse<IDistrict[]>> {
        return this.http.get<IDistrict[]>(this.districtsResourceUrl, { observe: 'response', params: { provinceCode } });
    }
    filterProvince(): Observable<HttpResponse<IProvince[]>> {
        return this.http.get<IProvince[]>(this.provincesResourceUrl, { observe: 'response' });
    }
}
