import { TestBed } from '@angular/core/testing';
import { ReviewService } from './review.service';

describe('AddressService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReviewService = TestBed.get(ReviewService);
    expect(service).toBeTruthy();
  });
});