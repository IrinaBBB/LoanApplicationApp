import { Component } from '@angular/core';
import { MainService } from '../../_services/main.service';

@Component({
    selector: 'app-loan-application',
    templateUrl: './loan-application.component.html',
    styleUrls: ['./loan-application.component.css'],
})
export class LoanApplicationComponent {
    constructor(private mainService: MainService) {}

    sendLoadApplication(): any {
      //this.mainService.postApplication()
    }
}
