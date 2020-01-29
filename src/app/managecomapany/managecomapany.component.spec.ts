import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagecomapanyComponent } from './managecomapany.component';

describe('ManagecomapanyComponent', () => {
  let component: ManagecomapanyComponent;
  let fixture: ComponentFixture<ManagecomapanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagecomapanyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagecomapanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
