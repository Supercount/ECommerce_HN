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

  productList !: Produit[];
  categories:string[] = ["Bague", "Collier", "Bracelet"];
  ordre:string = "";
  filtres:string[] = [];
  
  form!: FormGroup;

  constructor(private produitService :ProduitsService, private formBuilder : FormBuilder) {
    this.form = formBuilder.group({
    filtres:  new FormArray([])
    }); }

    
  changeCheckbox(event: Event) {
    console.log(event.target);
  }

  submit() {
    console.log(this.form.value);
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
    });
    this.produitService.getProducts().subscribe({
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
