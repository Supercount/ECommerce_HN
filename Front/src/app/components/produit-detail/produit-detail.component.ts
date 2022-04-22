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
  quantite !: number;
  produit: Produit = {
    id:1,
    nom:"Bague plaquée Or Rose",
    prix:90,
    description:"Une superbe bague qui ravira tout le monde fkjseghkjbflsgleqfb erjfg qkgfql ksjfqk gqjh hqkjs bqkj gkq fqlqbkjglfq hgjejrh flkqglkqh mgq hj h:fkqh geq h",
    couleur: "pink",
    categorie:"Bague",
    image:"https://www.maty.com/contenu/pagesstatiquesRWD/511/images/bijoux-bague.jpg"
  };

  constructor(private route: ActivatedRoute, private service : ProduitsService, private router: Router) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));

    // this.service.getProduit(this.id).subscribe({
    //   next: produit => {
    //     this.produit = produit;
    //   }, error: err => {
    //     console.log(err);
    //   }, complete: () => {
    //     console.log('fin de chargement');
    //   }
    // });
  }

  delete() {
    this.service.delete(this.id);
    this.router.navigate(['/products']);
  }

  ajouterPanier() {
    this.service.ajouterPanier(this.produit, this.quantite);
  }

}
