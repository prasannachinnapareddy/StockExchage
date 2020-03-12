import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './user/register/register.component';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { from } from 'rxjs';
import { UsersComponent } from './users/users.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { UserComponent } from './update/user/user.component';
import { UserHomePageComponent } from './user-home-page/user-home-page.component';
import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
import { ImportDtaComponent } from './import-dta/import-dta.component';
 import { ManagecomapanyComponent } from './managecomapany/managecomapany.component';
 import { ManageexchangeComponent } from './manageexchange/manageexchange.component';
 import { UpdateipodetailsComponent } from './updateipodetails/updateipodetails.component';
import { CreateNewCompanyComponent } from './create-new-company/create-new-company.component';
import { CompanyComponent } from './update/company/company.component';
import { HomeComponent } from './home/home.component';
import { IposComponent } from './ipos/ipos.component';
import { CompareCompanyComponent } from './user/compare-company/compare-company.component';
import { CompareSectorComponent } from './user/compare-sector/compare-sector.component';
import { IpoUpdateComponent } from './user/ipo-update/ipo-update.component';
import { StockexchangeComponent } from './stockexchange/stockexchange.component';
import { ActivateComponent } from './activate/activate.component';
import { UpdatestockComponent } from './updatestock/updatestock.component';
import { PlaceorderComponent } from './placeorder/placeorder.component';
import { CompanieslistComponent } from './companieslist/companieslist.component';
import { ViewiposComponent } from './viewipos/viewipos.component';
import { ChartsComponent } from './charts/charts.component';
import { HighchartsChartComponent } from "../../node_modules/highcharts-angular";
import { LogoutComponent } from './logout/logout.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HttpInterceptorService } from './service/http-interceptor.service';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    UsersComponent,
    UserComponent,
    UserHomePageComponent,
     AdminHomePageComponent,
     ImportDtaComponent,
    ManagecomapanyComponent,
    ManageexchangeComponent,
     UpdateipodetailsComponent,
     CreateNewCompanyComponent,
     CompanyComponent,
     HomeComponent,
     IposComponent,
     CompareCompanyComponent,
     CompareSectorComponent,
     IpoUpdateComponent,
     StockexchangeComponent,
     ActivateComponent,
     UpdatestockComponent,
     PlaceorderComponent,
     CompanieslistComponent,
     ViewiposComponent,
     ChartsComponent,
     HighchartsChartComponent,
     LogoutComponent,
     ContactUsComponent,
     ProfileComponent,
     UpdateProfileComponent
  ],  
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass:HttpInterceptorService,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
