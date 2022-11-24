package com.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "karyawan")

public class Karyawan implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @OneToMany
    // @JoinColumn()
    // private Rekening rekening;
    
    // @OneToOne(cascade = CascadeType.ALL)
    // private DetailKaryawan detailkaryawan;

    // @OneToMany(cascade = CascadeType.ALL)
    // private KaryawanTraining karyawantraining;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "deleted_date")
    private Date deleted_date;

    @Column(name = "updated_date")
    private Date updated_date;
    
    @Column(name = "alamat")
    private String alamat;
    
    @Column(name = "dob")
    private Date dob;

    @Column(name = "jk")
    private String jk;

    @Column(name = "nama")
    private String nama;

    @Column(name = "status")
    private String status;

    public Karyawan(Long id, Date created_date, Date deleted_date, Date updated_date, String alamat, Date dob,
            String jk, String nama, String status) {
        this.id = id;
        this.created_date = created_date;
        this.deleted_date = deleted_date;
        this.updated_date = updated_date;
        this.alamat = alamat;
        this.dob = dob;
        this.jk = jk;
        this.nama = nama;
        this.status = status;
    }

    
}