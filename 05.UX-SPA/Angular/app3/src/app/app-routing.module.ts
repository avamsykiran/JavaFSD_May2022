import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccountHolderReactiveFormComponent } from './account-holder-reactive-form/account-holder-reactive-form.component';
import { AccountHoldersComponent } from './account-holders/account-holders.component';
import { TxnsComponent } from './txns/txns.component';

const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'/accounts'},
  {path:'accounts',component:AccountHoldersComponent},
  {path:'addAccount',component:AccountHolderReactiveFormComponent},
  {path:'editAccount/:ahId',component:AccountHolderReactiveFormComponent},
  {path:'statement/:ahId',component:TxnsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
