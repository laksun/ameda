import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyfilesComponent} from './myfiles/myfiles.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MyfileDetailComponent } from './myfile-detail/myfile-detail.component';

const routes: Routes = [
  { path: 'myfiles', component: MyfilesComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'detail/:id', component: MyfileDetailComponent}
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes)],
})

export class AppRoutingModule { }
