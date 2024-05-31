import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from "./login.component";
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  { path: 'login', component: LoginComponent }
];

@NgModule({
  declarations: [LoginComponent], // Agregar LoginComponent a las declaraciones
  imports: [RouterModule.forChild(routes),
    FormsModule,
  ],
  providers: []
})
export class LoginModule {}
