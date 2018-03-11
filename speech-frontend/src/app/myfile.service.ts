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

  getMyFile(id: number): Observable<MyFile> {
    this.messageService.add(`MyfileService: fetched file id=${id}`);
    return of(MYFILES.find(myfile => myfile.id === id));
  }
}
