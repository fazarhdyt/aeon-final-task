package com.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "training")

public class Training implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @OneToMany(cascade = CascadeType.ALL)
    // private KaryawanTraining karyawantraining;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "deleted_date")
    private Date deleted_date;

    @Column(name = "updated_date")
    private Date updated_date;

    @Column(name = "nama_pengajar")
    private String nama_pengajar;

    @Column(name = "tema")
    private String tema;

    public Training(Long id, Date created_date, Date deleted_date, Date updated_date, String nama_pengajar,
            String tema) {
        this.id = id;
        this.created_date = created_date;
        this.deleted_date = deleted_date;
        this.updated_date = updated_date;
        this.nama_pengajar = nama_pengajar;
        this.tema = tema;
    }

    

}
