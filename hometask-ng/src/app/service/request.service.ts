import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Request } from '../model/request';
import { Observable } from 'rxjs';

@Injectable()
export class RequestService {

  private requestUrl: string;

  constructor(private http: HttpClient) {
    this.requestUrl = 'http://localhost:8084/requests';
  }

  public findAll(): Observable<Request[]> {
    return this.http.get<Request[]>(this.requestUrl);
  }

  public save(request: Request) {
    return this.http.post<Request>(this.requestUrl, request);
  }

  public getRequestById(id: number): Observable<Request> {
    return this.http.get<Request>(this.requestUrl + '/' + id);
  }
}
