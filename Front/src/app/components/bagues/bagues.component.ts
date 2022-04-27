import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/models/produit';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-bagues',
  templateUrl: './bagues.component.html',
  styleUrls: ['./bagues.component.css']
})
export class BaguesComponent implements OnInit {

  constructor(private produitService :ProduitsService) { }
  ordre !:string;

  productList !: Produit[];

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
