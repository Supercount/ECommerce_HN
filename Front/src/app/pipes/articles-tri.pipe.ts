import { Pipe, PipeTransform } from '@angular/core';
import { Produit } from '../models/produit';

@Pipe({
  name: 'articlesTri'
})
export class ArticlesTriPipe implements PipeTransform {

  transform(values: Produit[], order: string): Produit[] {
    if (order === 'DESC') {
      return values.sort((a: Produit, b: Produit) => b.price - a.price);
    } else {
      return values.sort((a: Produit, b: Produit) => a.price - b.price);
    }
  }
}
