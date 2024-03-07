package ru.aurorahost.LoanAppOpenApi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Laanetaker")
public class LaanetakerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "laanetakerEntities")
    private Set<LaanesoeknadEntity> laanesoeknadEntities = new HashSet<>();

    @Column(name = "foedselsnummer")
    private Long foedselsnummer;

    @Column(name = "navn")
    private String navn;

    @Column(name = "foedselsdato")
    private Date foedselsdato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoedselsnummer() {
        return foedselsnummer;
    }

    public void setFoedselsnummer(Long foedselsnummer) {
        this.foedselsnummer = foedselsnummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Date getFoedselsdato() {
        return foedselsdato;
    }

    public void setFoedselsdato(Date foedselsdato) {
        this.foedselsdato = foedselsdato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaanetakerEntity that = (LaanetakerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(laanesoeknadEntities, that.laanesoeknadEntities) && Objects.equals(foedselsnummer, that.foedselsnummer) && Objects.equals(navn, that.navn) && Objects.equals(foedselsdato, that.foedselsdato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, laanesoeknadEntities, foedselsnummer, navn, foedselsdato);
    }
}