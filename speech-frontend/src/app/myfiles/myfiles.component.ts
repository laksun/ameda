import { Component, OnInit } from '@angular/core';
import { MyFile } from '../myfile';
import { MyfileService } from '../myfile.service';


@Component({
  selector: 'app-myfiles',
  templateUrl: './myfiles.component.html',
  styleUrls: ['./myfiles.component.css']
})
export class MyfilesComponent implements OnInit {

  myfile: MyFile ={
    id: 1,
    name: 'Myfile1.pdf'
  };

  myfiles : MyFile[];

  selectedFile: MyFile;

  onSelect(aFile: MyFile): void {
    this.selectedFile = aFile;
  }
  
  constructor(private myfileService: MyfileService) { }

  ngOnInit() {
    this.getMyFiles();
  }

  getMyFiles(): void {
    this.myfileService.getMyFiles().subscribe(myfiles => this.myfiles = myfiles);
  }

}
