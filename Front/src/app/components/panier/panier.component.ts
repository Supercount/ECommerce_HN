import { Component, OnInit } from '@angular/core';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  
  panier = localStorage.getItem("panier");
  panierList = (this.panier != null)? JSON.parse(this.panier) : [];

  constructor(private service : ProduitsService) { }

  ngOnInit(): void {
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
