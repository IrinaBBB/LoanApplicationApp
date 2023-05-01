import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { LoanApplicationComponent } from './loan-application/loan-application.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

const routes: Routes = [{ path: '', component: LoanApplicationComponent }];

@NgModule({
    declarations: [AppComponent, LoanApplicationComponent],
    imports: [
        BrowserModule,
        RouterModule.forRoot(routes),
        HttpClientModule,
        FormsModule,
    ],
    exports: [RouterModule],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}
