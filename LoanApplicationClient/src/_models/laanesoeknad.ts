import { Laanetaker } from './laanetaker';

export interface Laanesoeknad {
    id: number | null;
    laanetakere: Laanetaker[] | null;
    laanebeloep: number | null;
    behov: String | null;
    loepetid: number | null;
    avdragsfriPeriode: number | null;
    type: String | null;
}
