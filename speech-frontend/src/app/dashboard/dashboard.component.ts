import { Component, OnInit } from '@angular/core';
import { MyFile } from '../myfile';
import { MyfileService } from '../myfile.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  myfiles: MyFile[] = [];

  constructor(private myfileService: MyfileService) { }

  ngOnInit() {
   this.getFiles();
  }


  getFiles(): void {
    this.myfileService.getMyFiles().subscribe(myfiles => this.myfiles = myfiles.slice(1, 5));
  }

}
