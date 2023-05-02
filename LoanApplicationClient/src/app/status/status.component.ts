import { Component } from '@angular/core';
import { MainService } from '../../_services/main.service';

@Component({
    selector: 'app-status',
    templateUrl: './status.component.html',
    styleUrls: ['./status.component.css'],
})
export class StatusComponent {
    showResult = false;
    applicationId: any;
    status: any;

    constructor(private mainService: MainService) {}

    getStatus(id: any) {
        this.mainService.getStatus(id).subscribe(
            (data) => {
                this.status = data.data;
                this.showResult = true;
            },
            (error) => {
                console.log(error);
                this.status = 'ukjent';
            }
        );
    }
}
