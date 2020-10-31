import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { PostulationComponent } from './components/postulation/postulation.component';
import { SujetsComponent } from './components/sujets/sujets.component';
import { ContactComponent } from './components/contact/contact.component';
import { AuthentificationComponent } from './components/authentification/authentification.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AcceuilComponent,
    PostulationComponent,
    SujetsComponent,
    ContactComponent,
    AuthentificationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
