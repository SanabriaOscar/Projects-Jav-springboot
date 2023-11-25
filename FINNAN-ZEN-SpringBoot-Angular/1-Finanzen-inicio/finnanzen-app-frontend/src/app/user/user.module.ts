// user.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListUserComponent } from './list-user/list-user.component';
import { FormUserComponent } from './form-user/form-user.component';
import { UserService } from './user.service';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
    { path: 'users', component: ListUserComponent },
    { path: 'users/form', component: FormUserComponent },
    { path: 'users/form/:id', component: FormUserComponent }
];


@NgModule({
  declarations: [ListUserComponent, FormUserComponent],
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterModule.forChild(routes)],
  providers: [UserService]
})
export class UserModule {}

