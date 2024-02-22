// form-user.component.ts
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
  userForm!: FormGroup;

  constructor(
    private userService: UserService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
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
    const formData = this.userForm.value;

    if (formData.idUser) {
      this.updateUser(formData);
    } else {
      this.createUser(formData);
    }
  }

  createUser(formData: any): void {
    this.userService.createUser(formData).subscribe(
      (response) => {
        console.log('Create user response:', response);
        Swal.fire('¡Guardado!', response, 'success');
        this.router.navigate(['/users']);
      },
      (error) => {
        console.error('Error saving user:', error);
        Swal.fire('Error', error, 'error');
      }
    );
  }

  updateUser(formData: any): void {
    this.userService.updateUser(formData).subscribe(
      (response) => {
        console.log('Update user response:', response);
        Swal.fire('¡Actualizado!', response, 'success');
        this.router.navigate(['/users']);
      },
      (error) => {
        console.error('Error updating user:', error);

        if (error instanceof HttpErrorResponse && error.error instanceof ProgressEvent) {
          Swal.fire('Error', 'Hubo un problema de red al actualizar el usuario.', 'error');
        } else {
          Swal.fire('Error', 'Hubo un problema al actualizar el usuario.', 'error');
        }
      }
    );
  }
}
