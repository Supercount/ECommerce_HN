import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/models/produit';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-ensembles',
  templateUrl: './ensembles.component.html',
  styleUrls: ['./ensembles.component.css']
})
export class EnsemblesComponent implements OnInit {

  constructor(private produitService :ProduitsService) { }
  ordre !:string;

  productList : Produit[] = [
    {
      id:1,
      nom:"product1",
      prix:90,
      description:"description product 1",
      couleur: "pink",
      categorie:"Bague",
      image:"https://www.maty.com/contenu/pagesstatiquesRWD/511/images/bijoux-bague.jpg"
    },
    {
      id:2,
      nom:"produit2",
      prix:100,
      description:"description produit2",
      couleur: "gold",
      categorie:"Collier",
      image:"https://www.maty.com/contenu/pagesstatiquesRWD/511/images/bijoux-bague.jpg"
    }
  ];

  ngOnInit(): void {
    
    this.produitService.getBagues().subscribe({
      next: products => {
        this.productList = products;
      }, error: err => {
        console.log(err);
      }, complete: () => {
        console.log('fin de chargement');
      }
    }
    );
  }
}
