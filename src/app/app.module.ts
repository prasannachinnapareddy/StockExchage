import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './user/register/register.component';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { from } from 'rxjs';
import { UsersComponent } from './users/users.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
// import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
// import { ImportDtaComponent } from './import-dta/import-dta.component';
// import { ManagecomapanyComponent } from './managecomapany/managecomapany.component';
// import { ManageexchangeComponent } from './manageexchange/manageexchange.component';
// import { UpdateipodetailsComponent } from './updateipodetails/updateipodetails.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    UsersComponent
    // AdminHomePageComponent,
    // ImportDtaComponent,
    // ManagecomapanyComponent,
    // ManageexchangeComponent,
    // UpdateipodetailsComponent
  ],  
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
