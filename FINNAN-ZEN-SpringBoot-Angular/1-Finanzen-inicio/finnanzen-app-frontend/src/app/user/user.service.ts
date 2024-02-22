// user.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/api/users';

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
    return this.http.post<any>(this.apiUrl, user, { observe: 'response' }).pipe(
      map((response: HttpResponse<any>) => {
        return response.body;
      }),
      catchError(this.handleErrors)
    );
  }

  updateUser(user: User): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${user.idUser}`, user, { observe: 'response' }).pipe(
      map((response: HttpResponse<any>) => {
        return response.body;
      }),
      catchError(this.handleErrors)
    );
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`).pipe(
      catchError(this.handleErrors)
    );
  }

  private handleErrors(error: any): Observable<never> {
    console.error('Error:', error);
    return throwError('Hubo un problema en la solicitud. Por favor, inténtelo de nuevo.');
  }
}
