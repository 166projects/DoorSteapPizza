import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodcountComponent } from './foodcount.component';

describe('FoodcountComponent', () => {
  let component: FoodcountComponent;
  let fixture: ComponentFixture<FoodcountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FoodcountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodcountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
