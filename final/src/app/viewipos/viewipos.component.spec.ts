import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewiposComponent } from './viewipos.component';

describe('ViewiposComponent', () => {
  let component: ViewiposComponent;
  let fixture: ComponentFixture<ViewiposComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewiposComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewiposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
