import { TestBed } from '@angular/core/testing';

import { ServiceRouteService } from './service-route.service';

describe('ServiceRouteService', () => {
  let service: ServiceRouteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceRouteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
