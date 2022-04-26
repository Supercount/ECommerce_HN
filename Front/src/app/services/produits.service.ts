import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  private BASE_URL = "http://localhost:8080/api/products";

  getProducts(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/all`);
  }

  getBagues(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/ring`);
  }

  getColliers(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/necklace`);
  }

  getGourmettes(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/chain`);
  }

  getEnsembles(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(`${this.BASE_URL}/set`);
  }

  getProduit(id: number): Observable<Produit> {
    return this.httpClient.get<Produit>(`${this.BASE_URL}/${id}`);
  }

  delete(id: number): void {
    this.httpClient.delete(`${this.BASE_URL}/products/${id}`).subscribe();
  }

  ajouterPanier(produit: Produit, quantite: number): void {
    let panier = localStorage.getItem("panier");
    let panierJSON = (panier != null) ? JSON.parse(panier) : [];
    let elementPresent = false;
    for (let i = 0; i < panierJSON.length; i++) {
      if (panierJSON[i].product == produit.id) {
        elementPresent = true;
        panierJSON[i].quantity += quantite;
      }
    }
    if (!elementPresent) {
      panierJSON.push({ product: produit.id, quantity: quantite });
    }
    panier = JSON.stringify(panierJSON);
    console.log(panier);
    localStorage.setItem("panier", panier);
  }

  constructor(private httpClient: HttpClient) { }
}
