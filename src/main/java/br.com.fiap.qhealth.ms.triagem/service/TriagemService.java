package br.com.fiap.qhealth.ms.triagem.service;

import br.com.fiap.qhealth.ms.triagem.dto.TriagemRequest;
import br.com.fiap.qhealth.ms.triagem.dto.TriagemResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class TriagemService {

    public TriagemResponse determinaPrioridade(TriagemRequest request) {
        //Realizar chamada ao usuarioService para obter idade do paciente
        boolean ePreferencial = TriagemService.ePreferencial(request);
        return new TriagemResponse(ePreferencial);
    }

    private static boolean ePreferencial(TriagemRequest triagemRequest) {
        long condicoesPositivas = Stream.of(
                triagemRequest.anamnese().eFumante(),
                triagemRequest.anamnese().eGravida(),
                triagemRequest.anamnese().eDiabetico(),
                triagemRequest.anamnese().eHipertenso()
            )
            .filter(Objects::nonNull)
            .filter(Boolean::booleanValue)
            .count();
        return condicoesPositivas > 2;
    }
}
