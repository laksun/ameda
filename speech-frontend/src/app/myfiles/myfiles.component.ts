import { Component, OnInit } from '@angular/core';
import { MyFile } from '../myfile';
import { MYFILES } from '../mock-files';


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

  myfiles = MYFILES;

  selectedFile: MyFile;

  onSelect(aFile: MyFile): void {
    this.selectedFile = aFile;
  }
  
  constructor() { }

  ngOnInit() {
  }

}
