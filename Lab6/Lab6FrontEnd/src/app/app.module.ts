import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes} from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import { ButtonComponent } from './button/button.component';

import { FormsModule }   from '@angular/forms';
import { UpdateComponent } from './update/update.component';
import { ListofComponent } from './listof/listof.component';

const routes: Routes = [
  {path: '', component:ButtonComponent},
  {path: 'button', component:ButtonComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ButtonComponent,
    UpdateComponent,
    ListofComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
