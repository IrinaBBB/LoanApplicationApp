package com.irinabalkarova.loanapplicationapi.model;

import java.util.List;

public class Laanesoeknad {
    private long id;
    private List<Laanetaker> lanetakere;
    private double lanebelop;
    private String behov;
    private int lopetid;
    private int avdragsfriPeriode;
    private Laanetype type;
    private Status status;
}
