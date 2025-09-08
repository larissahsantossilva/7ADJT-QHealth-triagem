package br.com.fiap.qhealth.ms.triagem.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TriagemRequest(
    @NotNull(message = "Id do paciente é obrigatório")
    @NotEmpty(message = "Id do paciente não pode ser vazio")
    String idPaciente,
    @NotNull(message = "Anamnese é obrigatório")
    @Valid
    AnamneseRequest anamnese) {
}
