import { Component, OnInit } from '@angular/core';
import { MyFile } from '../myfile';
import { MyfileService } from '../myfile.service';


@Component({
  selector: 'app-myfiles',
  templateUrl: './myfiles.component.html',
  styleUrls: ['./myfiles.component.css']
})
export class MyfilesComponent implements OnInit {


  myfiles: MyFile[];

  constructor(private myfileService: MyfileService) { }

  ngOnInit() {
    this.getMyFiles();
  }

  getMyFiles(): void {
    this.myfileService.getMyFiles().subscribe(myfiles => this.myfiles = myfiles);
  }

}
