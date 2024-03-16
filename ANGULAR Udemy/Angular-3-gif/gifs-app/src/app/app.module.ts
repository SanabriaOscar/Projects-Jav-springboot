import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule }from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './shared/component/sidebar/sidebar.component';
import { GifsModule } from "./gifs/gifs.module";

@NgModule({
    declarations: [
        AppComponent,
        SidebarComponent,

    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        GifsModule,
        HttpClientModule
    ]
})
export class AppModule { }
