import { TestBed } from '@angular/core/testing';

import { ProductPostTypeService } from './product-post-type.service';

describe('AddressService', () => {
    beforeEach(() => TestBed.configureTestingModule({}));

    it('should be created', () => {
        const service: ProductPostTypeService = TestBed.get(ProductPostTypeService);
        expect(service).toBeTruthy();
    });
});
