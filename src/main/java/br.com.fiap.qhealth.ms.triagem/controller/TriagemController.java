package br.com.fiap.qhealth.ms.triagem.controller;

import br.com.fiap.qhealth.ms.triagem.dto.TriagemRequest;
import br.com.fiap.qhealth.ms.triagem.dto.TriagemResponse;
import br.com.fiap.qhealth.ms.triagem.service.TriagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static br.com.fiap.qhealth.ms.triagem.controller.TriagemController.V1_TRIAGEM;

@RestController
@RequestMapping(V1_TRIAGEM)
@RequiredArgsConstructor
public class TriagemController {
    public static final String V1_TRIAGEM = "api/v1/triagem";
    public static final Logger logger = Logger.getLogger(TriagemController.class.getName());

    public final TriagemService triagemService;

    @PostMapping
    public ResponseEntity<TriagemResponse> defineTriagem(@RequestBody TriagemRequest triagemRequest) {
        logger.info("GET | {} | Iniciado defineTriagem");
        ResponseEntity<TriagemResponse> response = ResponseEntity.ok(triagemService.determinaPrioridade(triagemRequest));
        logger.info("GET | {} | Finalizado defineTriagem");
        return response;
    }
}
