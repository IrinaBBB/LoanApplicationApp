package com.irinabalkarova.loanapplicationapi.repository;

import com.irinabalkarova.loanapplicationapi.exception.ConstraintViolationException;
import com.irinabalkarova.loanapplicationapi.model.Laanesoeknad;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

public class LaanesoeknadRepository {
    private static long NEXT_ID = 1L;

    private HashMap<Long, Laanesoeknad> laanesoeknader = new HashMap<>();

    public void save(Laanesoeknad laanesoeknad) throws ConstraintViolationException {
        laanesoeknad.setId(NEXT_ID);
        if(this.laanesoeknader.containsValue(laanesoeknad)){
            throw new ConstraintViolationException();
        }
        this.laanesoeknader.put(NEXT_ID++, laanesoeknad);
    }
}
