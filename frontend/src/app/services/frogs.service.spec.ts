import { TestBed } from '@angular/core/testing';

import { FrogsService } from './frogs.service';

describe('FrogsService', () => {
  let service: FrogsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FrogsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
