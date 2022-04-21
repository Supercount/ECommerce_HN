import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.css']
})
export class ProduitDetailComponent implements OnInit {
  
  id !: number;
  
  produit!: Produit;

  constructor(private route: ActivatedRoute, private service : ProduitsService, private router: Router) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));

    this.service.getProduit(this.id).subscribe({
      next: produit => {
        this.produit = produit;
      }, error: err => {
        console.log(err);
      }, complete: () => {
        console.log('fin de chargement');
      }
    });
  }

  delete() {
    this.service.delete(this.id);
    this.router.navigate(['/products']);
  }

}
