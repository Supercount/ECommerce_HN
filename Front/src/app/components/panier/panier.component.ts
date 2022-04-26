import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/models/produit';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  
  panier = localStorage.getItem("panier");
  panierList = (this.panier != null)? JSON.parse(this.panier) : [];
  articles!: any[];

  constructor(private service : ProduitsService) { }

  ngOnInit(): void {
    for (let index = 0; index < this.panierList.length; index++) {
      const element = this.panierList[index];
      this.service.getProduit(element.id).subscribe({
          next: produit => {
            let commande = produit + " " + element.quantity;
            this.articles.push(commande);
          }, error: err => {
            console.log(err);
          }, complete: () => {
            console.log(this.articles);
            console.log('fin de chargement');
          }
        });
    }
  }

  supprimer(id: number): void {
    for (let i = 0; i < this.panierList.length; i++) {
      if (this.panierList[i].product == id) {
        this.panierList.splice(i, 1);
      }
    }
    this.panier = JSON.stringify(this.panierList);
    localStorage.setItem("panier", this.panier);
    window.location.reload();
  }

}
