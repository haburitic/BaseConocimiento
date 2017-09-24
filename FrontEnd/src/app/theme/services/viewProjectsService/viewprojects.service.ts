import { Injectable } from '@angular/core';
import { Projects } from './projects';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class ViewProjectsService {

  private url = 'http://localhost:8080/gnrproject';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private project: Projects = new Projects();

  constructor(private http: Http) {

  }

  
  deleteProject(id: number)  {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }  


  getProjects(): Observable<Projects[]> {
    let url = `${this.url}/findall`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getProject(id: number): Observable<Projects> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  addProject(project: Projects) {
    let url = `${this.url}/save`;
    let iJson = JSON.stringify(project);
    return this.http.post(url, iJson, { headers: this.headers })
      .map(r => r.json())
      .catch(this.handleError);
  }

  putProject(project: Projects) {

    let url = `${this.url}/edit/${project.idgnrprj}`;
    let iJson = JSON.stringify(project);
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