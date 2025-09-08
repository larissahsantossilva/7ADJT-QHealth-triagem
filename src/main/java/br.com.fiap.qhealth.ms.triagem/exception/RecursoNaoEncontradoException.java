package br.com.fiap.qhealth.ms.triagem.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public RecursoNaoEncontradoException(String errorMessage) {
        super(errorMessage);
    }
}
