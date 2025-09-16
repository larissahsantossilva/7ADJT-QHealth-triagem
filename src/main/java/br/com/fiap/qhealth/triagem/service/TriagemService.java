package br.com.fiap.qhealth.triagem.service;

import br.com.fiap.qhealth.triagem.dto.TriagemRequest;
import br.com.fiap.qhealth.triagem.dto.TriagemResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Stream;

@Service
public class TriagemService {

    public TriagemResponse determinaPrioridade(TriagemRequest request) {
        try {
            boolean ePreferencial = TriagemService.ePreferencial(request);
            return new TriagemResponse(ePreferencial);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao determinar prioridade de triagem", e);
        }
    }

    private static boolean ePreferencial(TriagemRequest triagemRequest) {
        int idade = calculaIdade(triagemRequest.dataNascimento());

        if (idade >= 60) {
            return true;
        }

        long condicoesPositivas = Stream.of(
                        triagemRequest.anamnese().fumante(),
                        triagemRequest.anamnese().gravida(),
                        triagemRequest.anamnese().diabetico(),
                        triagemRequest.anamnese().hipertenso()
                )
                .filter(Boolean::booleanValue)
                .count();

        return condicoesPositivas > 2;
    }

    private static int calculaIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}

