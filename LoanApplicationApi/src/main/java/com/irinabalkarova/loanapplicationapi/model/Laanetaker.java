package com.irinabalkarova.loanapplicationapi.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Laanetaker {
    private Long fodselsnummer;
    private String navn;
    private LocalDate fodselsdato;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laanetaker)) return false;
        Laanetaker that = (Laanetaker) o;
        return getFodselsnummer().equals(that.getFodselsnummer());
    }

    @Override
    public int hashCode() {
        return getFodselsnummer().hashCode();
    }
}
