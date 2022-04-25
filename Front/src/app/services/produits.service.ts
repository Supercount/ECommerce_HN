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
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/ring`);
  }
  
  getColliers() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/necklace`);
  }

  getGourmettes() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/chain`);
  }

  getEnsembles() : Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/get/set`);
  }

  getProduit(id: number) : Observable<Produit> {
    return this.httpClient.get<Produit>(`${this.BASE_URL}/get/products/${id}`);
  }

  delete(id: number): void {
    this.httpClient.delete(`${this.BASE_URL}/products/${id}`).subscribe();
  }

  ajouterPanier(produit: Produit, quantite: number): void {
    let panier = localStorage.getItem("panier");
    if (panier == null) {
      panier = {"product": produit.id, "quantity": quantite}.toString();
    } else {
      let panierJSON =  JSON.parse(panier);
      for (let i = 0; i < panierJSON.length; i++) {
        if (panierJSON[i].product == produit.id) {
          panierJSON[i].quantity += quantite;
        }
      }
      panier = JSON.stringify(panierJSON);
    }
    localStorage.setItem("panier", panier);
  }

  constructor(private httpClient : HttpClient) { }
}
