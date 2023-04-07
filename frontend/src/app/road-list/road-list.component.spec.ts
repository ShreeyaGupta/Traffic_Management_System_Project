import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoadListComponent } from './road-list.component';

describe('RoadListComponent', () => {
  let component: RoadListComponent;
  let fixture: ComponentFixture<RoadListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoadListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RoadListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
