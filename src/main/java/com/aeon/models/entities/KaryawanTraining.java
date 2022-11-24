package com.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "karyawan_training")

public class KaryawanTraining implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "karyawan_id")
    private Karyawan karyawan;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "deleted_date")
    private Date deleted_date;

    @Column(name = "updated_date")
    private Date updated_date;

    public KaryawanTraining(Long id, Date created_date, Date deleted_date, Date updated_date) {
        this.id = id;
        this.created_date = created_date;
        this.deleted_date = deleted_date;
        this.updated_date = updated_date;
    }

    
}
