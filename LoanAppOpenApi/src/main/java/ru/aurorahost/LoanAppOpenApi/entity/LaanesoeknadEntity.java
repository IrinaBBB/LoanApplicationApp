package ru.aurorahost.LoanAppOpenApi.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "laanesoeknad")
public class LaanesoeknadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "laanesoeknad_laanetaker",
            joinColumns = { @JoinColumn(name = "laanesoeknad_id") },
            inverseJoinColumns = { @JoinColumn(name = "laanetaker_id") }
    )
    Set<LaanetakerEntity> lanetakere = new HashSet<>();

    @Column(name = "lanebelop")
    private Double lanebelop;

    @Column(name = "behov")
    private String behov;

    @Column(name = "lopetid")
    private Integer lopetid;

    @Column(name = "avdragsfriPeriode")
    private Integer avdragsfriPeriode;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private LaanetypeEntity type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEntity status = StatusEntity.MOTTATT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLanebelop() {
        return lanebelop;
    }

    public void setLanebelop(Double lanebelop) {
        this.lanebelop = lanebelop;
    }

    public String getBehov() {
        return behov;
    }

    public void setBehov(String behov) {
        this.behov = behov;
    }

    public Integer getLopetid() {
        return lopetid;
    }

    public void setLopetid(Integer lopetid) {
        this.lopetid = lopetid;
    }

    public Integer getAvdragsfriPeriode() {
        return avdragsfriPeriode;
    }

    public void setAvdragsfriPeriode(Integer avdragsfriPeriode) {
        this.avdragsfriPeriode = avdragsfriPeriode;
    }

    public LaanetypeEntity getType() {
        return type;
    }

    public void setType(LaanetypeEntity type) {
        this.type = type;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public Set<LaanetakerEntity> getLanetakere() {
        return lanetakere;
    }

    public void setLanetakere(Set<LaanetakerEntity> laanetakerEntities) {
        this.lanetakere = laanetakerEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaanesoeknadEntity that = (LaanesoeknadEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(lanebelop, that.lanebelop) && Objects.equals(behov, that.behov) && Objects.equals(lopetid, that.lopetid) && Objects.equals(avdragsfriPeriode, that.avdragsfriPeriode) && type == that.type && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lanetakere, lanebelop, behov, lopetid, avdragsfriPeriode, type, status);
    }
}