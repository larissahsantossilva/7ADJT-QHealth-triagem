package br.com.fiap.qhealth.triagem.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TriagemRequest(

        @NotNull(message = "Data de nascimento é obrigatório")
        LocalDate dataNascimento,

        @NotNull(message = "Anamnese é obrigatório")
        @Valid
        AnamneseRequest anamnese) {
}
