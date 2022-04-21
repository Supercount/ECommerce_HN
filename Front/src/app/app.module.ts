import { LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ProduitsComponent } from './components/produits/produits.component';
import { ProduitComponent } from './components/produit/produit.component';
import localeFR from '@angular/common/locales/fr';
import { registerLocaleData } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';

registerLocaleData(localeFR);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProduitsComponent,
    ProduitComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{provide: LOCALE_ID, useValue: 'fr-FR'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
