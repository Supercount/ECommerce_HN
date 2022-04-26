import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class UsersService {
  URL_API = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }

  //Get All users

  getAll() {
    return this.http.get<User[]>(`${this.URL_API}/users`);

  }

  delete(id: Number) {

    return this.http.delete(`${this.URL_API}/users/${id}`);

  }

  post(users: User) {

    return this.http.post<User>(`${this.URL_API}/users/new_user`, users);

  }

  update(users: User) {
    return this.http.put(`${this.URL_API}/users/${users.id}`, users)
  }


}
