package br.com.fiap.qhealth.triagem.service;


import br.com.fiap.qhealth.triagem.dto.AnamneseRequest;
import br.com.fiap.qhealth.triagem.dto.TriagemRequest;
import br.com.fiap.qhealth.triagem.dto.TriagemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TriagemServiceTest {

    private TriagemService triagemService;

    @BeforeEach
    void setUp() {
        triagemService = new TriagemService();
    }

    @Test
    void determinaPrioridade_deveRetornarTrue_quandoIdadeMaiorOuIgual60() {
        TriagemRequest request = mock(TriagemRequest.class);
        AnamneseRequest anamnese = mock(AnamneseRequest.class);

        when(request.dataNascimento()).thenReturn(LocalDate.now().minusYears(65));
        when(request.anamnese()).thenReturn(anamnese);

        when(anamnese.fumante()).thenReturn(false);
        when(anamnese.gravida()).thenReturn(false);
        when(anamnese.diabetico()).thenReturn(false);
        when(anamnese.hipertenso()).thenReturn(false);

        TriagemResponse response = triagemService.determinaPrioridade(request);

        assertTrue(response.preferencial());
    }

    @Test
    void determinaPrioridade_deveRetornarTrue_quandoMaisDeDuasCondicoesPositivas() {
        TriagemRequest request = mock(TriagemRequest.class);
        AnamneseRequest anamnese = mock(AnamneseRequest.class);

        when(request.dataNascimento()).thenReturn(LocalDate.now().minusYears(30));
        when(request.anamnese()).thenReturn(anamnese);

        when(anamnese.fumante()).thenReturn(true);
        when(anamnese.gravida()).thenReturn(true);
        when(anamnese.diabetico()).thenReturn(true);
        when(anamnese.hipertenso()).thenReturn(false);

        TriagemResponse response = triagemService.determinaPrioridade(request);

        assertTrue(response.preferencial());
    }

    @Test
    void determinaPrioridade_deveRetornarFalse_quandoIdadeMenorQue60_eMenosOuIgualADuasCondicoes() {
        TriagemRequest request = mock(TriagemRequest.class);
        AnamneseRequest anamnese = mock(AnamneseRequest.class);

        when(request.dataNascimento()).thenReturn(LocalDate.now().minusYears(30));
        when(request.anamnese()).thenReturn(anamnese);

        when(anamnese.fumante()).thenReturn(true);
        when(anamnese.gravida()).thenReturn(false);
        when(anamnese.diabetico()).thenReturn(true);
        when(anamnese.hipertenso()).thenReturn(false);

        TriagemResponse response = triagemService.determinaPrioridade(request);

        assertFalse(response.preferencial());
    }

    @Test
    void determinaPrioridade_deveLancarRuntimeException_quandoRequestNulo() {
        assertThrows(RuntimeException.class, () -> triagemService.determinaPrioridade(null));
    }

}

