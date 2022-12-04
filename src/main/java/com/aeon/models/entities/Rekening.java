package com.aeon.models.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "rekening")

public class Rekening extends AbstractDate implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jenis")
    private String jenis;
    
    @Column(name = "nama")
    private String nama;
    
    @Column(name = "nomor")
    private String nomor;
    
    @ManyToOne
    @JoinColumn(name = "karyawan_id")
    private Karyawan karyawan;

}
