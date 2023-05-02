import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Laanesoeknad } from '../_models/laanesoeknad';
import { Observable } from 'rxjs';
import { FeilMelding } from '../_models/feilMelding';

@Injectable({
    providedIn: 'root',
})
export class MainService {
    constructor(private http: HttpClient) {}

    postApplication(
        model: Laanesoeknad
    ): Observable<Laanesoeknad | FeilMelding> {
        return this.http
            .post<Laanesoeknad>('http://localhost:8095/v1/application', model)
            .pipe((data: any) => {
                return data;
            });
    }
}
