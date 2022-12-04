package com.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "karyawan_training")
public class KaryawanTraining extends AbstractDate implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tanggal_training")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalTraining;
    
    @ManyToOne()
    @JoinColumn(name = "karyawan_id", referencedColumnName = "id")
    private Karyawan karyawan;

    @ManyToOne()
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

}
