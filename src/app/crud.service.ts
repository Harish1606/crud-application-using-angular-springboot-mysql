import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  private url='http://localhost:8091/';
  constructor(private http:HttpClient) { }

  public getAllUsers():Observable<any>{
    return this.http.get(this.url+'get');
  }

  public getUser(id:number):Observable<any>{
    return this.http.get(this.url+'get/'+id);
  }

  public addUser(user:User):Observable<Object>{
    return this.http.post<User>(this.url+'post',user);
  }

  public updateUser(id:number,user:User):Observable<Object>{
    return this.http.put<User>(this.url+'update/'+id,user);
  }

  public deleteUser(id:number):Observable<any>{
    return this.http.delete(this.url+'delete/'+id,{responseType:'text'});
  }
}
