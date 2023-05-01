import { Component } from '@angular/core';
import { MainService } from '../../_services/main.service';

@Component({
    selector: 'app-status',
    templateUrl: './status.component.html',
    styleUrls: ['./status.component.css'],
})
export class StatusComponent {
    constructor(private mainService: MainService) {}
}
