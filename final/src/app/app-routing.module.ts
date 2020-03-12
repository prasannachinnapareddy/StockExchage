import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './user/register/register.component';
import { LoginComponent } from './login/login.component';
import { UsersComponent } from './users/users.component';
import { UserComponent } from './update/user/user.component';
import {UpdatestockComponent} from './updatestock/updatestock.component'
import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
import { UserHomePageComponent } from './user-home-page/user-home-page.component';
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
import { PlaceorderComponent } from './placeorder/placeorder.component';
import { CompanieslistComponent } from './companieslist/companieslist.component';
import { ViewiposComponent } from './viewipos/viewipos.component';
import { ChartsComponent } from './charts/charts.component';
import { LogoutComponent } from './logout/logout.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
//import { SignInGuard } from './sign-in.guard';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'contact-us',component:ContactUsComponent},
 {path:'register' ,component:RegisterComponent},
 {path:'login',component:LoginComponent},
 {path:'users',component:UsersComponent},
 {path:'user',component:UserComponent},
 {path:'admin-home-page',component:AdminHomePageComponent},
 {path:'user-home-page',component:UserHomePageComponent},
 {path:'import-dta',component:ImportDtaComponent},
 {path:'activate',component:ActivateComponent},
 {path:'profile',component:ProfileComponent},
 {path:'update-profile',component:UpdateProfileComponent},
 {path:'create-new-company',component:CreateNewCompanyComponent},
  {path:'managecompany',component:ManagecomapanyComponent},
 {path:'manageexchange',component:ManageexchangeComponent},
 {path:'stockexchange',component:StockexchangeComponent},
  {path:'updateipodetails',component:UpdateipodetailsComponent},
  {path:'ipo-update',component:IpoUpdateComponent},
  {path:'company',component:CompanyComponent},
  {path:'ipos',component:IposComponent},
  {path:'updatestock',component: UpdatestockComponent},
  {path:'compare-company',component:CompareCompanyComponent},
  {path:'compare-sector',component:CompareSectorComponent},
  {path:'placeorder',component:PlaceorderComponent},
  {path:'companieslist',component:CompanieslistComponent},
  {path:'viewipos',component:ViewiposComponent},
  {path:'charts',component:ChartsComponent},
  {path:'logout',component:LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
