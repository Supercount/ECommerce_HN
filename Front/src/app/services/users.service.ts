import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  URL_API_JS = 'http://localhost:3000/users';

  constructor(private http: HttpClient) { }

  //Get All users

  getAll() {
    return this.http.get<User[]>(this.URL_API_JS);

  }

  delete(id: Number) {

    return this.http.delete(`${this.URL_API_JS}/${id}`);

  }

  post(users: any) {

    return this.http.post<User>(this.URL_API_JS, users);

  }

  update(users: any) {
    return this.http.put(`${this.URL_API_JS}/${users.id}`, users)
  }


}
