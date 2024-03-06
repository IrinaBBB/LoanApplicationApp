package com.irinabalkarova.loanapplicationapi.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Laanetaker {

    private UUID id;

    @NotBlank
    @Pattern(regexp = "^(0[1-9]|[12]\\d|3[01])(0[1-9]|1[0-2])(\\d{2})(\\d{5})$\n", message = "Feil format på " +
            "fødselsnummer")
    private Long foedselsnummer;

    @NotBlank
    @Size(min = 2, max = 100)
    private String navn;

    @NotNull
    private LocalDate foedselsdato;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laanetaker)) return false;
        Laanetaker that = (Laanetaker) o;
        return getFoedselsnummer().equals(that.getFoedselsnummer());
    }

    @Override
    public int hashCode() {
        return getFoedselsnummer().hashCode();
    }
}
