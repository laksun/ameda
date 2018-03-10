import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { MyfilesComponent } from './myfiles/myfiles.component';
import { MyfileDetailComponent } from './myfile-detail/myfile-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    MyfilesComponent,
    MyfileDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
