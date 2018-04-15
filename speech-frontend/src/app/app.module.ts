import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { MyfilesComponent } from './myfiles/myfiles.component';
import { MyfileDetailComponent } from './myfile-detail/myfile-detail.component';
import { MyfileService } from './myfile.service';
import { MessagesComponent } from './messages/messages.component';
import { MessagesService } from './messages.service';
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    MyfilesComponent,
    MyfileDetailComponent,
    MessagesComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    MyfileService,
    MessagesService,
    /* ...*/
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
