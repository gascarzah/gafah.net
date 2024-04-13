import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ArticuloVistaComponent } from './articulo-vista.component';

describe('ArticuloVistaComponent', () => {
  let component: ArticuloVistaComponent;
  let fixture: ComponentFixture<ArticuloVistaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticuloVistaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticuloVistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
