import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  URL_API = 'http://localhost:8080/api/users';
  URL_API_REGISTER = 'http://localhost:8080/api/auth';
  constructor(private http: HttpClient) { }

  //Get All users

  getAll() {
    return this.http.get<User[]>(`${this.URL_API}`);

  }

  delete(id: Number) {

    return this.http.delete(`${this.URL_API}/${id}`);

  }

  post(users: User) {

    return this.http.post<User>(`${this.URL_API}`, users);

  }

  update(users: User) {
    return this.http.put(`${this.URL_API}/${users.id}`, users)
  }
  signup(user: User) {

    return this.http.post<User>(`${this.URL_API_REGISTER}/signup`, user);


  }
  signin(user: User) {

    console.log(user);
    return this.http.post<User>(`${this.URL_API_REGISTER}/signin`, user);


  }
}
