import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { AccountHoldersComponent } from './account-holders/account-holders.component';
import { AccountHolderFormComponent } from './account-holder-form/account-holder-form.component';
import { NumberSeriesComponent } from './number-series/number-series.component';
import { NumberSeriesGroupComponent } from './number-series-group/number-series-group.component';

const routes : Routes =[
  {path:'',pathMatch:'full',redirectTo:'/accounts'},
  {path:'accounts',component:AccountHoldersComponent},
  {path:'addAccount',component:AccountHolderFormComponent},
  {path:'obDemo',component:NumberSeriesGroupComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AccountHoldersComponent,
    AccountHolderFormComponent,
    NumberSeriesComponent,
    NumberSeriesGroupComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
