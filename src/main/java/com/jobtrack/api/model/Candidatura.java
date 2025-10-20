package com.jobtrack.api.model;

import com.jobtrack.api.enums.StatusCandidatura;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "candidatura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloVaga;
    private String empresa;
    private LocalDate dataCandidatura;

    @Enumerated(EnumType.STRING)
    private StatusCandidatura status;

    private String urlVaga;
    private LocalDate proximaAcaoData;
}
