import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { IDistrict } from '../address/model/district.model';

@Injectable({
    providedIn: 'root'
})
export class LegalStatusService {
    public legalStatusResourceUrl = SERVER_API_URL + 'api/legal-status';

    constructor(private http: HttpClient) {}

    getLegalStatus(): Observable<HttpResponse<IDistrict[]>> {
        return this.http.get<IDistrict[]>(this.legalStatusResourceUrl, { observe: 'response' });
    }
}
