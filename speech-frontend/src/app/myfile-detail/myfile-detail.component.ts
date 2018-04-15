import { Component, OnInit, Input } from '@angular/core';
import { MyFile } from '../myfile';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { MyfileService } from '../myfile.service';

@Component({
  selector: 'app-myfile-detail',
  templateUrl: './myfile-detail.component.html',
  styleUrls: ['./myfile-detail.component.css']
})
export class MyfileDetailComponent implements OnInit {
  @Input() myfile: MyFile;

  constructor( private route: ActivatedRoute,
                private myfileService: MyfileService,
                private location: Location) { }

  ngOnInit() {
    this.getmyFile();
  }

  getmyFile(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.myfileService.getMyFile(id).subscribe(myfile => this.myfile = myfile);
  }

  goBack(): void {
    this.location.back();
  }

}
