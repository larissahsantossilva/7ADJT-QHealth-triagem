package br.com.fiap.qhealth.triagem.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TriagemConstantsTest {

    @Test
    public void testConstants() {
        assertEquals("200", TriagemConstants.HTTP_STATUS_CODE_200);
        assertEquals("Triagem realizada com sucesso.", TriagemConstants.TRIAGEM_REALIZADA_COM_SUCESSO);
        assertEquals("Erro ao realizar a triagem.", TriagemConstants.ERRO_AO_REALIZAR_TRIAGEM);
        assertEquals("422", TriagemConstants.HTTP_STATUS_CODE_422);
    }

}

