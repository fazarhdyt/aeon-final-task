package com.aeon.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "karyawan")

public class Karyawan extends AbstractDate implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "alamat is required")
    @Column(name = "alamat")
    private String alamat;
    
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @NotEmpty(message = "jenis kelamin is required")
    @Column(name = "jk")
    private String jk;

    @NotEmpty(message = "nama is required")
    @Column(name = "nama")
    private String nama;

    @NotEmpty(message = "status is required")
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "karyawan", cascade = CascadeType.ALL)
    private List<Rekening> rekenings =  new ArrayList<>();
    
    @OneToOne(mappedBy = "karyawan", cascade = CascadeType.ALL)
    private DetailKaryawan detailKaryawan;
    
    @JsonIgnore
    @OneToMany(mappedBy = "karyawan", cascade = CascadeType.ALL)
    private List<KaryawanTraining> karyawanTrainings = new ArrayList<>();
    
}