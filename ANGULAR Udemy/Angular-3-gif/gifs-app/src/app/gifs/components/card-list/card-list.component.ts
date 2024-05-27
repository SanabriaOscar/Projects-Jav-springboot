import { Component, Input } from '@angular/core';
import { Gif } from '../../interfaces/gifs.interfaces';

@Component({
  selector: 'gifs-card-list',
  templateUrl: './card-list.component.html',
})
export class CardListComponent {

  @Input()
  public gifs: Gif[]=[];
//nesecito crea un componente que  muestre una lista de imagenes en forma de tarjeta (con titulo y descripcion)

  constructor(){}
}
