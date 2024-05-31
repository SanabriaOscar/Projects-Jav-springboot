import { User } from './../user/user.model';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router, Routes } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email?: string;
  password?: string;
  errorMessage?: string;

  constructor(private http: HttpClient, private router: Router) {}

  login() {
    const loginPayload = {
      email: this.email,
      password: this.password
    };

    const loginUrl = 'http://localhost:8080/login';

    this.http.post(loginUrl, loginPayload).subscribe((response: any) => {
      console.log('Inicio de sesión exitoso', response);
      // Redirigir al usuario a la página de usuarios después del inicio de sesión exitoso
      this.router.navigate(['/users']);
    }, (error: HttpErrorResponse) => {
      if (error.error instanceof ErrorEvent) {
        // Error del lado del cliente
        this.errorMessage = `Error: ${error.error.message}`;
      } else {
        // Error de respuesta del servidor
        this.errorMessage = `Error: ${error.status} - ${error.error}`;
      }
    });
  }
}
