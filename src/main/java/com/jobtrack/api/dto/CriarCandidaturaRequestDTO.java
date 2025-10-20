package com.jobtrack.api.dto;

import com.jobtrack.api.enums.StatusCandidatura;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarCandidaturaRequestDTO {

    @NotNull(message = "O nome da vaga é obrigatório.")
    private String tituloVaga;

    @NotNull(message = "O nome da empresa é obrigatório.")
    private String empresa;

    @PastOrPresent(message = "A data de candidatura não pode ser futura.")
    @NotNull(message = "É obrigatório informar a data de inscrição da vaga.")
    private LocalDate dataCandidatura;

    @Enumerated(EnumType.STRING)
    private StatusCandidatura statusCandidatura;
}
