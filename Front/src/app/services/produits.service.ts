import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  private BASE_URL = "http://localhost:3000";

  getProducts() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/products`);
  }

  constructor(private httpClient : HttpClient) { }
}
