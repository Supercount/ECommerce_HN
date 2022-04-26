import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/models/produit';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-gourmettes',
  templateUrl: './gourmettes.component.html',
  styleUrls: ['./gourmettes.component.css']
})
export class GourmettesComponent implements OnInit {

  constructor(private produitService: ProduitsService) { }
  ordre !: string;

  productList !: Produit[];

  ngOnInit(): void {
    this.produitService.getGourmettes().subscribe({
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
