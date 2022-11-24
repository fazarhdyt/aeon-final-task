package com.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rekening")

public class Rekening implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "karyawan_id")
    private Karyawan karyawan;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "deleted_date")
    private Date deleted_date;

    @Column(name = "updated_date")
    private Date updated_date;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "nama")
    private String nama;

    @Column(name = "nomor")
    private String nomor;

    public Rekening(Long id, Date created_date, Date deleted_date, Date updated_date, String jenis, String nama,
            String nomor) {
        this.id = id;
        this.created_date = created_date;
        this.deleted_date = deleted_date;
        this.updated_date = updated_date;
        this.jenis = jenis;
        this.nama = nama;
        this.nomor = nomor;
    }

    
}
