package br.com.fiap.qhealth.triagem.controller;

import br.com.fiap.qhealth.triagem.dto.TriagemRequest;
import br.com.fiap.qhealth.triagem.dto.TriagemResponse;
import br.com.fiap.qhealth.triagem.service.TriagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TriagemControllerTest {

    @Mock
    private TriagemService triagemService;

    @InjectMocks
    private TriagemController triagemController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void defineTriagem_deveRetornarResponseEntityComTriagemResponse() {
        TriagemRequest request = mock(TriagemRequest.class);
        TriagemResponse expectedResponse = new TriagemResponse(true);

        when(triagemService.determinaPrioridade(ArgumentMatchers.any(TriagemRequest.class)))
                .thenReturn(expectedResponse);

        ResponseEntity<TriagemResponse> responseEntity = triagemController.defineTriagem(request);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody().preferencial());

        verify(triagemService, times(1)).determinaPrioridade(request);
    }
}

