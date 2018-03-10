import { TestBed, inject } from '@angular/core/testing';

import { MyfileService } from './myfile.service';

describe('MyfileService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MyfileService]
    });
  });

  it('should be created', inject([MyfileService], (service: MyfileService) => {
    expect(service).toBeTruthy();
  }));
});
