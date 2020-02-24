import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './user/register/register.component';
import { LoginComponent } from './login/login.component';
import { UsersComponent } from './users/users.component';
import { UserComponent } from './update/user/user.component';
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

const routes: Routes = [
  {path:'home',component:HomeComponent},
 {path:'register' ,component:RegisterComponent},
 {path:'login',component:LoginComponent},
 {path:'users',component:UsersComponent},
 {path:'user',component:UserComponent},
 {path:'admin-home-page',component:AdminHomePageComponent},
 {path:'user-home-page',component:UserHomePageComponent},
 {path:'import-dta',component:ImportDtaComponent},
 {path:'create-new-company',component:CreateNewCompanyComponent},
  {path:'managecompany',component:ManagecomapanyComponent},
 {path:'manageexchange',component:ManageexchangeComponent},
  {path:'updateipodetails',component:UpdateipodetailsComponent},
  {path:'ipo-update',component:IpoUpdateComponent},
  {path:'company',component:CompanyComponent},
  {path:'ipos',component:IposComponent},
  {path:'compare-company',component:CompareCompanyComponent},
  {path:'compare-sector',component:CompareSectorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
