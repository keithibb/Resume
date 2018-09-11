import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';
import { Reimbursement } from '../model/reimbursement.model';

@Injectable({providedIn: 'root'})
export class AuthService {

user: User;
emp: Reimbursement;

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>("http://localhost:8888/Project1/login.ng", {username: username, password: password},
  {withCredentials: true});
  }
  getCurrentUser(): Observable<any>{
    return this.http.post<any>('http://localhost:8888/Project1/checksession.ng',
    null, {withCredentials: true});
  }
  logout(): Observable<any> {
    return this.http.post<any>('http://localhost:8888/Project1/logout.ng',
     null, {withCredentials : true});
  }
  getReimb(username: string): Observable<any> {
    return this.http.post<any>('http://localhost:8888/Project1/GetRiemb.ng', {username: username} 
    , {withCredentials : true});
  }
  getAllReimb(): Observable<any> {
    return this.http.post<any>('http://localhost:8888/Project1/allreimbursements.ng',
   {withCredentials : true} );
  }
  addReimb(amount: number, description: string, type: string, author: string): Observable<any>{
  console.log(amount, description, type, author)
      return this.http.post<any>('http://localhost:8888.Project1/addReib.ng', { amount: amount, description: description, type: type, author: author },
   {withCredentials : true} );
  // return new Observable<any>();
  }
  updateReimb(reimbbId: number, resolver: string, status: string): Observable<any>{
  console.log(reimbbId, resolver, status)
    // return this.http.post<any>('http://localhost:8888.Project1/updateReimb', {reimbbId: reimbbId, resolver:resolver, status: status},
    // {withCredentials : true} );
    return new Observable<any>();
  }
}