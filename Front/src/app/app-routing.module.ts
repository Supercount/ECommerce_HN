import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BaguesComponent } from './components/bagues/bagues.component';
import { ColliersComponent } from './components/colliers/colliers.component';
import { LoginComponent } from './components/contact/login/login.component';
import { RegisterComponent } from './components/contact/register/register.component';
import { EnsemblesComponent } from './components/ensembles/ensembles.component';
import { GourmettesComponent } from './components/gourmettes/gourmettes.component';
import { PanierComponent } from './components/panier/panier.component';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';
import { ProduitsComponent } from './components/produits/produits.component';
import { ShowAllComponent } from './components/show-all/show-all.component';
import { UsersmanagerComponent } from './components/usersmanager/usersmanager.component';
import {ContactComponent} from "./components/contact/contact.component";

const routes: Routes = [
  // {
  // path: 'products',
  // component: ProduitsComponent
  // },
  {
  path: 'products/:id',
   component: ProduitDetailComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "contact",
    component: ContactComponent
  },
  {
    path: "",
    component: ShowAllComponent
  },
  {
    path: "bagues",
    component: BaguesComponent
  },
  {
    path: "gourmettes",
    component: GourmettesComponent
  },
  {
    path: "colliers",
    component: ColliersComponent
  },
  {
    path: "ensembles",
    component: EnsemblesComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "inscription",
    component: RegisterComponent
  },
  {
    path: "panier",
    component: PanierComponent
  },
  {
    path: 'users',
    component: UsersmanagerComponent
  },

  { path: 'home', redirectTo: '', pathMatch: 'full' },

  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
