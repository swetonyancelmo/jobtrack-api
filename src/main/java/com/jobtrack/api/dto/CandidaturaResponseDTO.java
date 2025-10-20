package com.jobtrack.api.dto;

import com.jobtrack.api.enums.StatusCandidatura;
import com.jobtrack.api.model.Candidatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidaturaResponseDTO {

    private Long id;
    private String tituloVaga;
    private String empresa;
    private StatusCandidatura statusCandidatura;

    public CandidaturaResponseDTO(Candidatura candidatura){
        this.id = candidatura.getId();
        this.tituloVaga = candidatura.getTituloVaga();
        this.empresa = candidatura.getEmpresa();
        this.statusCandidatura = candidatura.getStatus();
    }
}
