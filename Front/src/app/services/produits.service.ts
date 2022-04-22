import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../models/produit';
import {CreateProduit} from "../models/create-produit";
import {ProduitType} from "../models/produit-type";

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    })
  };
  private BASE_URL = "http://localhost:3000";
  constructor(private http: HttpClient) {
  }
  getProducts() : Observable<Produit[]> {
    return this.http.get<Produit[]>(`${this.BASE_URL}/products`);
  }

  getProduit(id: number) : Observable<Produit> {
    return this.http.get<Produit>(`${this.BASE_URL}/products/${id}`);
  }
  fetchAll(): Observable<Produit[]> {
    return this.http.get<Produit[]>(`${this.BASE_URL}/products`)
  }

  delete(id: number): void {
    this.http.delete(`${this.BASE_URL}/products/${id}`).subscribe();
  }


  fetchAllTypes(): Observable<ProduitType[]> {
  return this.http.get<ProduitType[]>(`${this.BASE_URL}/products/types`)
}

  create(produit: CreateProduit): Observable<Produit[]> {
return this.http.post<Produit[]>(`${this.BASE_URL}/products`, produit, this.httpOptions)
  }
}
