import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  //template: '<h1>hola mundo</h1>',
  template: `

<h1> counter: {{counter}}</h1>
<button (click)="increace(+1)">+1</button>
<button (click)="reset()">Reset</button>
<button (click)="increace(-1)">-1</button>
<hr>
  `,
  //templateUrl: './counter.component.html',
  //styleUrl: './counter.component.css',

})
export class CounterComponent {
  constructor(){}
  counter: number=10;
  increace(value: number) :void{
    this.counter+=value;
  }
  reset() :void{
    this.counter=10;
  }
}
