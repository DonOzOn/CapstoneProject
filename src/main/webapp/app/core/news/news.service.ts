import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { INews } from './news.model';

@Injectable({
    providedIn: 'root'
})
export class NewsService {
    public newsResourceUrl = SERVER_API_URL + 'api/news';
  
    constructor(private http: HttpClient) {}

    getListNews(): Observable<HttpResponse<INews[]>> {
        return this.http.get<INews[]>(this.newsResourceUrl, { observe: 'response'});
    }
  
}
