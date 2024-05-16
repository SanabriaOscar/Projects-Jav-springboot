// user.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { User } from './user.model';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/users';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {}

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl).pipe(
      catchError(this.handleErrors)
    );
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`).pipe(
      catchError(this.handleErrors)
    );
  }
  createUser(user: User): Observable<any> {
    return this.http.post<any>(this.apiUrl, user, { headers: this.httpHeaders, observe: 'response' }).pipe(
      map((response: HttpResponse<any>) => {
        return response.body; // Devuelve el cuerpo de la respuesta
      }),
      catchError(this.handleErrors)
    );
  }

  updateUser(user: User): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${user.idUser}`, user, { headers: this.httpHeaders, observe: 'response' }).pipe(
      map((response: HttpResponse<any>) => {
        return response.body;
      }),
      catchError(this.handleErrors)
    );
  }
  deleteUser(id: number): Observable<HttpEvent<any>> {
    const options = {
      headers: this.httpHeaders,
      reportProgress: true // Para observar el progreso de la solicitud
    };

    return this.http.request<any>('delete', `${this.apiUrl}/${id}`, options).pipe(
      catchError(this.handleErrors)
    );
  }


  private handleErrors(error: any): Observable<never> {
    console.error('Error:', error);
    let errorMessage = 'Hubo un problema en la solicitud. Por favor, inténtelo de nuevo.';

    if (error.status === 400 || error.status === 500) {
      errorMessage = error.error; // Puedes personalizar el mensaje de error dependiendo del status
    }
    // Mostrar el mensaje de error
    Swal.fire('Error', errorMessage, 'error');

    return throwError(errorMessage);
  }
}
