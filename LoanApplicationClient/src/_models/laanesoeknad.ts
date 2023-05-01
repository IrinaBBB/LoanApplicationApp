import { Laanetaker } from './laanetaker';

export interface Laanesoeknad {
    id: number;
    laanetakere: Laanetaker[];
    laanebeloep: number;
    behov: String;
    loepetid: number;
    avdragsfriPeriode: number;
    type: String;
}
