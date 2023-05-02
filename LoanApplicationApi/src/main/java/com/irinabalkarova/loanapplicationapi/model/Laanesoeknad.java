package com.irinabalkarova.loanapplicationapi.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class Laanesoeknad {
    private long id;
    private List<Laanetaker> lanetakere;

    private double lanebelop;

    @NotNull
    private String behov;
    private int lopetid;
    private int avdragsfriPeriode;
    private Laanetype type;
    private Status status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laanesoeknad)) return false;

        Laanesoeknad that = (Laanesoeknad) o;

        return getLanetakere() != null ? getLanetakere().equals(that.getLanetakere()) : that.getLanetakere() == null;
    }

    @Override
    public int hashCode() {
        return getLanetakere() != null ? getLanetakere().hashCode() : 0;
    }
}
