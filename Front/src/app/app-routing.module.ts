import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';
import { ProduitsComponent } from './components/produits/produits.component';

const routes: Routes = [
  {
    path: 'products',
    component: ProduitsComponent
  },
  {
    path: 'products/:id',
    component: ProduitDetailComponent
  },
  { path: '', redirectTo: 'products', pathMatch: 'full' },
  { path: 'home', redirectTo: 'products', pathMatch: 'full' },
  {
    path: '**',
    redirectTo: ''
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
