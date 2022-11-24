package com.aeon.models.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detail_karyawan")

public class DetailKaryawan implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_karyawan")
    private Karyawan karyawan;

    @Column(name = "nik")
    private String nik;

    @Column(name = "npwp")
    private String npwp;

    public DetailKaryawan(Long id, String nik, String npwp) {
        this.id = id;
        this.nik = nik;
        this.npwp = npwp;
    }

    
}
