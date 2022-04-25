import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  private BASE_URL = "http://localhost:3000/api";

  getProducts() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/products`);
  }
  
  getBagues() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/bagues`);
  }
  
  getColliers() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/colliers`);
  }

  getGourmettes() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/gourmettes`);
  }

  getEnsembles() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/ensembles`);
  }

  getProduit(id: number) : Observable<Produit> {
    return this.httpClient.get<Produit>(`${this.BASE_URL}/get/products/${id}`);
  }

  delete(id: number): void {
    this.httpClient.delete(`${this.BASE_URL}/products/${id}`).subscribe();
  }

  ajouterPanier(produit: Produit, quantite: number): void {

  }

  constructor(private httpClient : HttpClient) { }
}
