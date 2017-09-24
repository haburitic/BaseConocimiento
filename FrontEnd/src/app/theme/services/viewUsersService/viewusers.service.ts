import {Injectable} from '@angular/core';
import { Users } from './users';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/first';
import 'rxjs/add/operator/catch';

@Injectable()

export class ViewUsersService {

  private url = 'http://localhost:8080/user';
  private headers = new Headers({ 'Content-Type': 'application/json' });

private user: Users = new Users();
 

  constructor(private http: Http) {
    
  }

  deleteUser(id: number): Observable<Users> {
    let url = `${this.url}/delete/${id}`;
    return this.http.delete(url)
      .map(r => r.json())
      .catch(this.handleError);
  }

  getUser(id: number): Observable<Users> {
    const url = `${this.url}/find/${id}`;
    return this.http.get(url).
      map(res => res.json())
        .catch(this.handleError);
  }

  getUsers(): Observable<Users[]>{  
    let url = `${this.url}/findall`;
     return this.http.get(url)
     .map(r => r.json())
     .catch(this.handleError);
    }

    addUser(user: Users){
      let url  = `${this.url}/save`;
      let iJson = JSON.stringify(user);
      return this.http.post(url, iJson, {headers: this.headers})
      .map(r => r.json())
      .catch(this.handleError);
          }

          putUser(user: Users){
            
let url  = `${this.url}/edit/${user.idnuser}`;
let iJson = JSON.stringify(user);
return this.http.put(url,iJson,{headers: this.headers})
.map(r => r.json())
.catch(this.handleError);

}

    private handleError(error:Response | any){
    
    let errMsg: string;
    if(error instanceof Response){
    let body = error.json() || '';
    let err =  body.error || JSON.stringify(body);
    errMsg = `${error.status} - ${error.statusText || '' } ${err}`;
    
    }else{
    
      errMsg= error.message ? error.message : error.toString();
    }
    return Observable.throw(errMsg);
    }


}