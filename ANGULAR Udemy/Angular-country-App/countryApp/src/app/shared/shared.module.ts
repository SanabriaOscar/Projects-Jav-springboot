import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AboutPageComponent } from './pages/about-page/about-page.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { AppRoutingModule } from '../app-routing.module';
import { ContactPageComponent } from './components/contact-page/contact-page.component';



@NgModule({
  declarations: [


    HomePageComponent,
        AboutPageComponent,
        SideBarComponent,

        ContactPageComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule ],
  exports: [
    HomePageComponent,
    AboutPageComponent
  ,SideBarComponent,
  ContactPageComponent
  ]
})
export class SharedModule { }
