import { TestBed } from '@angular/core/testing';

import { Transactions2Service } from './transactions2.service';

describe('Transactions2Service', () => {
  let service: Transactions2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Transactions2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
