import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProduitsService} from "../../services/produits.service";
import {Produit} from "../../models/produit";
import {ProduitType} from "../../models/produit-type";
import {CreateProduit} from "../../models/create-produit";



@Component({
  selector: 'app-ajout-produit',
  templateUrl: './create-produit.component.html',
  styleUrls: ['./create-produit.component.css']
})
export class CreateProduitComponent implements OnInit {

  submitted: boolean = false;
  produit?: Produit;
  categorieList: ProduitType[] = [];

  createProduitForm: FormGroup = this.fb.group({
    nom: [this.produit?.nom, [Validators.required]],
    prix: [this.produit?.prix, [Validators.required]],
    categorie: [this.produit?.categorie, [Validators.required]],
    description: [this.produit?.description, [Validators.required]],
    quantite: [this.produit?.quantite, [Validators.required]],
    image: [this.produit?.image, [Validators.required]],
  });


  constructor(private produitsService: ProduitsService, private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.produitsService.fetchAllTypes()
      .subscribe({
        next: ProduitTypes => {
          this.categorieList = ProduitTypes;
        }
      });

  }

  onSubmit() {
    this.submitted = true;

    if (this.createProduitForm.invalid) {
      return;
    }


    let produit: Produit= {
      id:0,
      nom: this.createProduitForm.value.nom,
      prix: this.createProduitForm.value.prix,
      description: this.createProduitForm.value.description,
      categorie: this.createProduitForm.value.categorie,
      quantite: this.createProduitForm.value.quantite,
      couleur: this.createProduitForm.value.couleur,
      image: this.createProduitForm.value.image,
    };

    this.produitsService.create(produit)

      .subscribe({
        next: ok => {
        }
      });
  }

  get f() {
    return this.createProduitForm.controls;
  }

}
