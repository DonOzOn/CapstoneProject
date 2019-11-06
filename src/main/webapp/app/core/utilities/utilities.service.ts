import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { IUtilities } from './utilities.model';

@Injectable({
    providedIn: 'root'
})
export class UtilitiesService {
    public utilitiesResourceUrl = SERVER_API_URL + 'api/utilities';

    constructor(private http: HttpClient) {}

    getUtilities(): Observable<HttpResponse<IUtilities[]>> {
        return this.http.get<IUtilities[]>(this.utilitiesResourceUrl, { observe: 'response' });
    }
}
