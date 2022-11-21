import { TestBed } from '@angular/core/testing';

import { ArthService } from './arth.service';

describe('ArthService', () => {
  let service: ArthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ArthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('#sum',()=>{
    it('should return 2 given 1 and 1',()=>{
      expect(service.sum(1,1)).toBe(2);
    })
    it('should return -2 given -1 and -1',()=>{
      expect(service.sum(-1,-1)).toBe(-2);
    })
    it('should return 0 given 1 and -1',()=>{
      expect(service.sum(1,-1)).toBe(0);
    })
    it('should return 1 given 1 and 0',()=>{
      expect(service.sum(1,0)).toBe(1);
    })
  })

  
});
