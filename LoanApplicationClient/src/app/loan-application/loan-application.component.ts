import { Component } from '@angular/core';
import { MainService } from '../../_services/main.service';
import { Laanetaker } from '../../_models/laanetaker';
import { Laanesoeknad } from '../../_models/laanesoeknad';

@Component({
    selector: 'app-loan-application',
    templateUrl: './loan-application.component.html',
    styleUrls: ['./loan-application.component.css'],
})
export class LoanApplicationComponent {
    laanetaker1: Laanetaker = {
        fodselsnummer: null,
        navn: null,
        fodselsdato: null,
    };

    laanetaker2: Laanetaker = {
        fodselsnummer: null,
        navn: null,
        fodselsdato: null,
    };

    laanesoeknad: Laanesoeknad = {
        id: null,
        laanebeloep: null,
        behov: '',
        loepetid: null,
        avdragsfriPeriode: null,
        type: '',
        laanetakere: [this.laanetaker1, this.laanetaker2],
    };

    constructor(private mainService: MainService) {}

    sendLoanApplication(): any {
        // this.mainService
        //     .postApplication(this.laanesoeknad)
        //     .subscribe((response) => {
        //         console.log(response);
        //     });
      console.log(this.laanesoeknad);
    }
}
