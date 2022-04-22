import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Produit } from 'src/app/models/produit';
import { ProduitsService } from 'src/app/services/produits.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {

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
      couleur: "or",
      categorie:"Collier",
      image:"https://www.maty.com/contenu/pagesstatiquesRWD/511/images/bijoux-bague.jpg"
    }
  ];
  categories:string[] = ["Bague", "Collier", "Bracelet"];
  ordre:string = "";
  filtres:string[] = [];
  
  form!: FormGroup;

  constructor(private produitService :ProduitsService, private formBuilder : FormBuilder) {
    this.form = formBuilder.group({
    filtres:  new FormArray([])
    }); }

  onCheckboxChange(event: any) {
    const selectedFilters = (this.form.controls['filtres'] as FormArray);
    if (event.target.checked) {
      selectedFilters.push(new FormControl(event.target.value));
    } else {
      const index = selectedFilters.controls
      .findIndex(x => x.value === event.target.value);
      selectedFilters.removeAt(index);
    }
  }

  submit() {
    console.log(this.form.value);
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
    });
    // this.produitService.getProducts().subscribe({
    //   next: products => {
    //     this.productList = products;
    //   }, error: err => {
    //     console.log(err);
    //   }, complete: () => {
    //     console.log('fin de chargement');
    //   }
    // }
    // );
  }

}
