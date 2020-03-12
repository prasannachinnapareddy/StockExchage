import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportDtaComponent } from './import-dta.component';

describe('ImportDtaComponent', () => {
  let component: ImportDtaComponent;
  let fixture: ComponentFixture<ImportDtaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportDtaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportDtaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
