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
import { ArticlesTriPipe } from './pipes/articles-tri.pipe';

registerLocaleData(localeFR);

@NgModule({
  declarations: [
    AppComponent,
    ProduitsComponent,
    ProduitComponent,
    ProduitDetailComponent,
    NavbarComponent,
    ArticlesTriPipe
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
