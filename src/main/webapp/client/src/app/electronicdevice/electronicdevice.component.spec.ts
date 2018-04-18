import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectronicdeviceComponent } from './electronicdevice.component';

describe('ElectronicdeviceComponent', () => {
  let component: ElectronicdeviceComponent;
  let fixture: ComponentFixture<ElectronicdeviceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ElectronicdeviceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ElectronicdeviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
