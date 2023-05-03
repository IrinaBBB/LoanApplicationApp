package com.irinabalkarova.loanapplicationapi.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Laanesoeknad {
    private long id;

    @Valid
    private List<Laanetaker> lanetakere;

    @NotNull
    private double lanebelop;

    @NotNull(message = "Behov beskrivelse mangler")
    @NotEmpty
    private String behov;

    @NotNull
    private int lopetid;

    @NotNull
    private int avdragsfriPeriode;

    @NotNull
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
