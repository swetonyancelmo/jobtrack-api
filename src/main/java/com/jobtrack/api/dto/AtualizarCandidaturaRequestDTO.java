package com.jobtrack.api.dto;

import com.jobtrack.api.enums.StatusCandidatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarCandidaturaRequestDTO {

    private StatusCandidatura statusCandidatura;
    private String urlVaga;
    private LocalDate proximaAcaoData;
}
