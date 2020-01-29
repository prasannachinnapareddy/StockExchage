import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './user/register/register.component';
import { LoginComponent } from './login/login.component';
import { UsersComponent } from './users/users.component';
// import { ImportDtaComponent } from './import-dta/import-dta.component';
// import { ManagecomapanyComponent } from './managecomapany/managecomapany.component';
// import { ManageexchangeComponent } from './manageexchange/manageexchange.component';
// import { UpdateipodetailsComponent } from './updateipodetails/updateipodetails.component';


const routes: Routes = [
 {path:'register' ,component:RegisterComponent},
 {path:'login',component:LoginComponent},
 {path:'users',component:UsersComponent}
 

//  {path:'import-dta',component:ImportDtaComponent},
//  {path:'managecompany',component:ManagecomapanyComponent},
//  {path:'manageexchange',component:ManageexchangeComponent},
//  {path:'updateipodetails',component:UpdateipodetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
