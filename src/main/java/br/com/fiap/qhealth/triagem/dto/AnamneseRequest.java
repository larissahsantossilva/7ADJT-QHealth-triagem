package br.com.fiap.qhealth.triagem.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AnamneseRequest(
        @NotNull(message = "Id é obrigatório")
        UUID id,

        @NotNull(message = "Fumante é obrigatório")
        boolean fumante,

        @NotNull(message = "Gravida é obrigatório")
        boolean gravida,

        @NotNull(message = "Diabetico é obrigatório")
        boolean diabetico,

        @NotNull(message = "Hipertenso é obrigatório")
        boolean hipertenso
) {
}
