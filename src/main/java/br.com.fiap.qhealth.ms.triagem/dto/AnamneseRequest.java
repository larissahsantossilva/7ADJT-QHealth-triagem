package br.com.fiap.qhealth.ms.triagem.dto;

import java.util.UUID;

public record AnamneseRequest(
    UUID id,
    Boolean eFumante,
    Boolean eGravida,
    Boolean eDiabetico,
    Boolean eHipertenso
) {
}
