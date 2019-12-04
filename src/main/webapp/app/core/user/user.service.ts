import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IUser } from './user.model';

@Injectable({ providedIn: 'root' })
export class UserService {
  public resourceUrl = SERVER_API_URL + 'api/users';
  public resourceUrlImage = SERVER_API_URL + 'api/upload';
  formData: IUser[];
  constructor(private http: HttpClient) {}

  create(user: IUser): Observable<IUser> {
    return this.http.post<IUser>(this.resourceUrl, user);
  }
  update(user: IUser): Observable<HttpResponse<IUser>> {
    return this.http.put<IUser>(this.resourceUrl, user, { observe: 'response' });
  }

  updateActive(user: IUser): Observable<HttpResponse<IUser>> {
    return this.http.put<IUser>(`${this.resourceUrl}/updateActive`, user, { observe: 'response' });
  }

  getListImage(): Observable<HttpResponse<any[]>> {
    return this.http.get<any[]>(this.resourceUrlImage, { observe: 'response' });
  }

  getImageByName(name: string): Observable<HttpResponse<any>> {
    return this.http.get<any>(`${this.resourceUrlImage}/files/${name}`, { observe: 'response' });
  }

  upload(uploadFiles: File): Observable<HttpResponse<any>> {
    const formData: FormData = new FormData();
    formData.append('file', uploadFiles, uploadFiles.name);
    return this.http.post<any>(this.resourceUrlImage, formData, { observe: 'response' });
  }

  searchKeywordQuery(text: string): Observable<HttpResponse<any>> {
    const param = new HttpParams();
    param.set('searchKey', text);
    return this.http.get<any>(`${this.resourceUrlImage}/search/`, { params: param, observe: 'response' });
  }

  find(login: string): Observable<IUser> {
    return this.http.get<IUser>(`${this.resourceUrl}/${login}`);
  }

  query(req?: any): Observable<HttpResponse<IUser[]>> {
    const options = createRequestOption(req);
    this.http
      .get(this.resourceUrl)
      .toPromise()
      .then(res => {
        this.formData = res as IUser[];
      });
    return this.http.get<IUser[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(login: string): Observable<any> {
    return this.http.delete(`${this.resourceUrl}+/${login}`);
  }

  authorities(): Observable<string[]> {
    return this.http.get<string[]>(SERVER_API_URL + 'api/users/authorities');
  }
}
