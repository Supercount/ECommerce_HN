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
  
  getBagues() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/bagues`);
  }
  
  getColliers() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/colliers`);
  }

  getGourmettes() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/gourmettes`);
  }

  getEnsembles() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/ensembles`);
  }

  getProduit(id: number) : Observable<Produit> {
    return this.httpClient.get<Produit>(`${this.BASE_URL}/products/${id}`);
  }

  delete(id: number): void {
    this.httpClient.delete(`${this.BASE_URL}/products/${id}`).subscribe();
  }

  ajouterPanier(produit: Produit, quantite: number): void {

  }

  constructor(private httpClient : HttpClient) { }
}
