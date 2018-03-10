import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { MyFile } from './myfile';
import { MYFILES } from './mock-files';

@Injectable()
export class MyfileService {

  constructor() { }

  getMyFiles() : Observable<MyFile[]>  {
    return of(MYFILES);
  }
}
