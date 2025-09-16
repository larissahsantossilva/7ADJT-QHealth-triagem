package br.com.fiap.qhealth.triagem.controller;

import br.com.fiap.qhealth.triagem.dto.TriagemRequest;
import br.com.fiap.qhealth.triagem.dto.TriagemResponse;
import br.com.fiap.qhealth.triagem.service.TriagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.fiap.qhealth.triagem.utils.TriagemConstants.*;

@Slf4j
@RestController
@Tag(name = "TriagemController", description = "Controller para realizar a triagem do paciente.")
@RequestMapping(value = TriagemController.V1_TRIAGEM,
        produces = "application/json")
@RequiredArgsConstructor
public class TriagemController {
    public static final String V1_TRIAGEM = "api/v1/triagens";

    public final TriagemService triagemService;

    @Operation(
            description = "Inicia atendimento.",
            summary = "Inicia fila para atendimento.",
            responses = {
                    @ApiResponse(
                            description = TRIAGEM_REALIZADA_COM_SUCESSO,
                            responseCode = HTTP_STATUS_CODE_200,
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(
                            description = ERRO_AO_REALIZAR_TRIAGEM,
                            responseCode = HTTP_STATUS_CODE_422,
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                    ),
            }
    )
    @PostMapping
    public ResponseEntity<TriagemResponse> defineTriagem(@Valid @RequestBody TriagemRequest triagemRequest) {
        log.info("POST | {} | Iniciado defineTriagem", V1_TRIAGEM);
        ResponseEntity<TriagemResponse> response = ResponseEntity.ok(triagemService.determinaPrioridade(triagemRequest));
        log.info("POST | {} | Finalizado defineTriagem", V1_TRIAGEM);
        return response;
    }

}
