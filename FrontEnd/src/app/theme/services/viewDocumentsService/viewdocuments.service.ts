import { Injectable } from '@angular/core';
import { Documents } from './documents';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';


@Injectable()

export class ViewDocumentsService {


  private url = 'http://localhost:8080/document';
  private headers = new Headers({ 'Content-Type': 'application/json' });


  constructor(private http: Http) {

  }

  deleteDocument(id: number): Observable<Documents> {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }
  
  getDocument(id: number): Observable<Documents> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url).
      map(res => res.json())
        .catch(this.handleError);
  }

  getDocuments(): Observable<Documents[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addDocument(document: Documents) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(document);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putDocument(document: Documents) {

    let url = `${this.url}/edit/${document.idndocument}`;
    let iJson = JSON.stringify(document);
    return this.http.put(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);

  }
  private handleError(error: Response | any) {

    let errMsg: string;
    if (error instanceof Response) {
      let body = error.json() || '';
      let err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;

    } else {

      errMsg = error.message ? error.message : error.toString();
    }
    return Observable.throw(errMsg);
  }


}