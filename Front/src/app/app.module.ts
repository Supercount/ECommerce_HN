import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProduitsComponent } from './components/produits/produits.component';
import { ProduitComponent } from './components/produit/produit.component';
import localeFR from '@angular/common/locales/fr';
import { registerLocaleData } from '@angular/common';
import { ProduitDetailComponent } from './components/produit-detail/produit-detail.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UsersTableComponent } from './components/users-table/users-table.component';
import { UsersmanagerComponent } from './components/usersmanager/usersmanager.component';
import { HeaderBijouterieComponent } from './components/header-bijouterie/header-bijouterie.component';
import { NavbarV2Component } from './components/navbar-v2/navbar-v2.component';
import { BaguesComponent } from './components/bagues/bagues.component';
import { ColliersComponent } from './components/colliers/colliers.component';
import { EnsemblesComponent } from './components/ensembles/ensembles.component';
import { GourmettesComponent } from './components/gourmettes/gourmettes.component';
import { RegisterComponent } from './components/contact/register/register.component';
import { LoginComponent } from './components/contact/login/login.component';
import { FooterComponent } from './components/footer/footer.component';
import { ShowAllComponent } from './components/show-all/show-all.component';
import { ArticlesTriPipe } from './pipes/articles-tri.pipe';
import { ContactComponent } from './components/contact/contact.component';

registerLocaleData(localeFR);

@NgModule({
  declarations: [
    AppComponent,
    ProduitsComponent,
    ProduitComponent,
    ProduitDetailComponent,
    NavbarComponent,
    UsersTableComponent,
    UsersmanagerComponent,
    HeaderBijouterieComponent,
    NavbarV2Component,
    BaguesComponent,
    ColliersComponent,
    EnsemblesComponent,
    GourmettesComponent,
    RegisterComponent,
    LoginComponent,
    FooterComponent,
    ShowAllComponent,
    ArticlesTriPipe,
    ContactComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'fr-FR' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
