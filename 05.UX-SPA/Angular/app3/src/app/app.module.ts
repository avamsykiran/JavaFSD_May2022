import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountHolderReactiveFormComponent } from './account-holder-reactive-form/account-holder-reactive-form.component';
import { AccountHoldersComponent } from './account-holders/account-holders.component';
import { TxnsComponent } from './txns/txns.component';
import { TxnFormRowComponent } from './txn-form-row/txn-form-row.component';
import { TxnRowComponent } from './txn-row/txn-row.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountHoldersComponent,
    AccountHolderReactiveFormComponent,
    TxnsComponent,
    TxnFormRowComponent,
    TxnRowComponent
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
