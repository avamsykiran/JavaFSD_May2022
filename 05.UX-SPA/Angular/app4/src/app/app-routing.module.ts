import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccountHolderReactiveFormComponent } from './account-holder-reactive-form/account-holder-reactive-form.component';
import { AccountHoldersComponent } from './account-holders/account-holders.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './services/auth.guard';
import { TxnsComponent } from './txns/txns.component';

const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'/login'},
//  {path:'accounts',component:AccountHoldersComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:AccountHolderReactiveFormComponent},
  {path:'statement/:ahId',component:TxnsComponent,canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
