import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { MyFile } from './myfile';
import { MYFILES } from './mock-files';

import { MessagesService } from './messages.service';

@Injectable()
export class MyfileService {

  constructor(private messageService: MessagesService) { }

  getMyFiles(): Observable<MyFile[]>  {
    this.messageService.add('MyFileService: fetched files');
    return of(MYFILES);
  }
}
