import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user.model';
import Swal from 'sweetalert2';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-form-user',
  templateUrl: './form-user.component.html',
  styleUrls: ['./form-user.component.css']
})
export class FormUserComponent implements OnInit {
  user: User = new User();
  userForm!: FormGroup; // Cambiado a tipo FormGroup
  // Quitado formBuilder: any;

  constructor(
    private userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder // Agregado aquí
  ) {
    this.initializeForm();
  }

  ngOnInit(): void {
    this.loadUser();
  }

  initializeForm(): void {
    this.userForm = this.formBuilder.group({
      idUser: [0],
      name: ['', Validators.required],
      lastname: ['', Validators.required],
      identification: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  loadUser(): void {
    this.activatedRoute.params.subscribe((params) => {
      const id = params['id'];
      if (id) {
        this.userService.getUserById(id).subscribe(
          (user) => {
            this.user = user;
            // Puedes establecer los valores del formulario aquí si es necesario
            this.userForm.patchValue(user);
          },
          (error) => {
            console.error('Error fetching user:', error);
          }
        );
      }
    });
  }

  saveUser(): void {
    // Obtén los valores del formulario
    const formData = this.userForm.value;

    if (formData.idUser) {
      this.updateUser(formData);
    } else {
      this.createUser(formData);
    }
  }

  createUser(formData: any): void {
    this.userService.createUser(formData).subscribe(
      () => {
        Swal.fire('¡Guardado!', 'Tu usuario ha sido guardado con éxito.', 'success');
        this.router.navigate(['/users']);
      },
      (error) => {
        console.error('Error saving user:', error);
        Swal.fire('Error', 'Hubo un problema al guardar el usuario.', 'error');
      }
    );
  }

  updateUser(formData: any): void {
    this.userService.updateUser(formData).subscribe(
      (response) => {
        console.log('Update user response:', response);
        Swal.fire('¡Actualizado!', 'Tu usuario ha sido actualizado con éxito.', 'success');
        this.router.navigate(['/users']);
      },
      (error) => {
        console.error('Error updating user:', error);
  
        if (error instanceof HttpErrorResponse && error.error instanceof ProgressEvent) {
          // Este bloque maneja errores de red o CORS
          Swal.fire('Error', 'Hubo un problema de red al actualizar el usuario.', 'error');
        } else {
          // Este bloque maneja otros tipos de errores, como errores de análisis JSON
          Swal.fire('Error', 'Hubo un problema al actualizar el usuario.', 'error');
        }
      }
    );
  }
  
  
}
