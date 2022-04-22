import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProduitComponent } from './components/create-produit/create-produit.component';

const routes: Routes = [


  {path:'addProduct',component:CreateProduitComponent},

  {
    path:'**',
    redirectTo:''
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
