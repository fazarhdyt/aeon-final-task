package com.aeon.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "training")

public class Training extends AbstractDate implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "nama pengajar is required")
    @Column(name = "nama_pengajar")
    private String namaPengajar;
    
    @NotEmpty(message = "tema is required")
    @Column(name = "tema")
    private String tema;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<KaryawanTraining> karyawanTrainings = new ArrayList<>();

}
