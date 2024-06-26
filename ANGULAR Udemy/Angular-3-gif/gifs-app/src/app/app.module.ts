import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './shared/component/sidebar/sidebar.component';
import { GifsModule } from "./gifs/gifs.module";
import { SharedModule } from './shared/shared.module';


@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,

  ],
  exports: [
    SidebarComponent,

  ],
  providers: [],
  bootstrap: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    GifsModule,
    SharedModule,
    HttpClientModule
  ]
})
export class AppModule { }
