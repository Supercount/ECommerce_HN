import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/models/produit';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-colliers',
  templateUrl: './colliers.component.html',
  styleUrls: ['./colliers.component.css']
})
export class ColliersComponent implements OnInit {

  constructor(private produitService :ProduitsService) { }
  ordre !:string;

  productList !: Produit[];

  ngOnInit(): void {
    
    this.produitService.getColliers().subscribe({
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
