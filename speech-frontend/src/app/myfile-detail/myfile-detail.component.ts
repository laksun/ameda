import { Component, OnInit, Input } from '@angular/core';
import { MyFile } from '../myfile';

@Component({
  selector: 'app-myfile-detail',
  templateUrl: './myfile-detail.component.html',
  styleUrls: ['./myfile-detail.component.css']
})
export class MyfileDetailComponent implements OnInit {
  @Input() myfile: MyFile;

  constructor() { }

  ngOnInit() {
  }

}
