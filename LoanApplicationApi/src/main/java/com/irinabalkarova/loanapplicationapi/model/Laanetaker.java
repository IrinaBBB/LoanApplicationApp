package com.irinabalkarova.loanapplicationapi.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Laanetaker {

    @NotBlank
    @Pattern(regexp = "^(0[1-9]|[12]\\d|3[01])(0[1-9]|1[0-2])(\\d{2})(\\d{5})$\n", message = "Feil format på " +
            "fødselsnummer")
    private Long fodselsnummer;

    @NotBlank
    @Size(min = 2, max = 100)
    private String navn;

    @NotNull
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
