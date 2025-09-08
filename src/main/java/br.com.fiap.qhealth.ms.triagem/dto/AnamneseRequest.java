package br.com.fiap.qhealth.ms.triagem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AnamneseRequest(
    @NotNull(message = "Id é obrigatório")
    UUID id,
    @NotNull(message = "eFumante é obrigatório")
    Boolean eFumante,
    @NotNull(message = "eGravida é obrigatório")
    Boolean eGravida,
    @NotNull(message = "eDiabetico é obrigatório")
    Boolean eDiabetico,
    @NotNull(message = "eHipertenso é obrigatório")
    Boolean eHipertenso
) {
}
