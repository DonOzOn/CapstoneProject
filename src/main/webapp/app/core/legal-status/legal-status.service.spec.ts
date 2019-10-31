import { TestBed } from '@angular/core/testing';
import { LegalStatusService } from './legal-status.service';

describe('LegalStatusService', () => {
    beforeEach(() => TestBed.configureTestingModule({}));

    it('should be created', () => {
        const service: LegalStatusService = TestBed.get(LegalStatusService);
        expect(service).toBeTruthy();
    });
});
