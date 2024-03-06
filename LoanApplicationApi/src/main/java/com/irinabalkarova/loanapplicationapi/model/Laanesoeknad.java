package com.irinabalkarova.loanapplicationapi.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Laanesoeknad {
    private UUID id;
    private List<Laanetaker> lanetakere;

    private double lanebelop;
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
