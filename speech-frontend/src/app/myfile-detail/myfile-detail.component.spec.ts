import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyfileDetailComponent } from './myfile-detail.component';

describe('MyfileDetailComponent', () => {
  let component: MyfileDetailComponent;
  let fixture: ComponentFixture<MyfileDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyfileDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyfileDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
