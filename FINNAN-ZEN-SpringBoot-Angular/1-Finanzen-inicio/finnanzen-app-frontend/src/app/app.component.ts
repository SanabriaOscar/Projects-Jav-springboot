import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'estoy trabajando con angular';
  curso ='El curso es angular';
  profesor='Oscar Sanabria Tavera';

  constructor(private router: Router) {}

  // Método para verificar si la página actual es la página de inicio de sesión
  isLoginPage(): boolean {
    return this.router.url === '/login';
  }
}
