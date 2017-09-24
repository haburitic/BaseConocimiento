import { Injectable } from '@angular/core';
import { SubProject } from './subproject';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class ViewSubProjectsService {

  private url = 'http://localhost:8080/project';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  private subproject: SubProject = new SubProject();

  constructor(private http: Http) {

  }

  deleteSubProject(id: number): Observable<SubProject> {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getSubProject(id: number): Observable<SubProject> {
    let url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getSubProjects(): Observable<SubProject[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addSubProject(subproject: SubProject) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(subproject);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putSubProject(subproject: SubProject) {

    let url = `${this.url}/edit/${subproject.shortnamespr}`;
    let iJson = JSON.stringify(subproject);
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

  getData(): Promise<any> {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve(this.getSubProjects());
      }, 2000);
    });
  }

}