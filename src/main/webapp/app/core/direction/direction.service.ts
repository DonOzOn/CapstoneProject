import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { IDistrict } from '../address/model/district.model';

@Injectable({
    providedIn: 'root'
})
export class DirectionService {
    public directionsResourceUrl = SERVER_API_URL + 'api/direction';

    constructor(private http: HttpClient) {}

    getDirection(): Observable<HttpResponse<IDistrict[]>> {
        return this.http.get<IDistrict[]>(this.directionsResourceUrl, { observe: 'response' });
    }
}
