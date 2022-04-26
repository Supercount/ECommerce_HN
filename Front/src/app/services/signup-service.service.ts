import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { User } from '../models/user';



@Injectable({
  providedIn: 'root'
})
export class SignupServiceService {

  URL_API_JS = 'http://localhost:3000/users';

  constructor(private http: HttpClient) { }

  post(users: any) {

    return this.http.post<User>(this.URL_API_JS, users);

  }


}
