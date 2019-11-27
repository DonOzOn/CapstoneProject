import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IUser } from './user.model';

@Injectable({ providedIn: 'root' })
export class UserService {
  public resourceUrl = SERVER_API_URL + 'api/users';
  public resourceUrlImage = SERVER_API_URL + 'api/upload';
  constructor(private http: HttpClient) {}

  create(user: IUser): Observable<IUser> {
    return this.http.post<IUser>(this.resourceUrl, user);
  }

  update(user: IUser): Observable<IUser> {
    return this.http.put<IUser>(this.resourceUrl, user);
  }

  getListImage(): Observable<HttpResponse<any[]>> {
    return this.http.get<any[]>(this.resourceUrlImage, { observe: 'response' });
  }

  getImageByName(name: string): Observable<HttpResponse<any>> {
    // eslint-disable-next-line
    console.log('lay anh ');
    return this.http.get<any>(`${this.resourceUrlImage}/files/${name}`, { observe: 'response' });
  }

  upload(uploadFiles: File): Observable<HttpResponse<any>> {
    const formData: FormData = new FormData();
    formData.append('file', uploadFiles, uploadFiles.name);
    return this.http.post<any>(this.resourceUrlImage, formData, { observe: 'response' });
  }

  find(login: string): Observable<IUser> {
    return this.http.get<IUser>(`${this.resourceUrl}/${login}`);
  }

  query(req?: any): Observable<HttpResponse<IUser[]>> {
    const options = createRequestOption(req);
    return this.http.get<IUser[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(login: string): Observable<any> {
    return this.http.delete(`${this.resourceUrl}+/${login}`);
  }

  authorities(): Observable<string[]> {
    return this.http.get<string[]>(SERVER_API_URL + 'api/users/authorities');
  }
}
