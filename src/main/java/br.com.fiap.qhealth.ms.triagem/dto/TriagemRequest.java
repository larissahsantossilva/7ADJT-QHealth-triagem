package br.com.fiap.qhealth.ms.triagem.dto;

public record TriagemRequest(
    String idPaciente,
    AnamneseRequest anamnese) {
}
