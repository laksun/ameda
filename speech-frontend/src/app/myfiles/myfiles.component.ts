import { Component, OnInit } from '@angular/core';
import { MyFile } from '../myfile';

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
  
  constructor() { }

  ngOnInit() {
  }

}
