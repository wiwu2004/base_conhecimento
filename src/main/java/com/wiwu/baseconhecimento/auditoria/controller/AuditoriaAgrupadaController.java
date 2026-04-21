package com.wiwu.baseconhecimento.auditoria.controller;

import com.wiwu.baseconhecimento.auditoria.dto.*;
import com.wiwu.baseconhecimento.auditoria.entity.PerguntaAuditoriaEntity;
import com.wiwu.baseconhecimento.auditoria.repository.PerguntaAuditoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaAgrupadaController {

    private final PerguntaAuditoriaRepository repository;

    public AuditoriaAgrupadaController(PerguntaAuditoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{codigoTipologia}/perguntas-por-secao")
    public ResponseEntity<List<SecaoPerguntasDTO>> listarPorSecao(
            @PathVariable String codigoTipologia
    ) {
        List<PerguntaAuditoriaEntity> perguntas =
                repository.buscarPorTipologiaOrdenadoPorSecao(codigoTipologia);

        Map<String, List<PerguntaAuditoriaDTO>> agrupadas = new LinkedHashMap<>();

        for (PerguntaAuditoriaEntity p : perguntas) {
            String titulo = (p.getSecao() != null)
                    ? p.getSecao().getTitulo()
                    : "Sem Seção";

            agrupadas
                    .computeIfAbsent(titulo, k -> new ArrayList<>())
                    .add(new PerguntaAuditoriaDTO(
                            p.getPergunta(),
                            p.getSignificado()
                    ));
        }

        List<SecaoPerguntasDTO> resposta = agrupadas.entrySet().stream()
                .map(e -> new SecaoPerguntasDTO(e.getKey(), e.getValue()))
                .toList();

        return ResponseEntity.ok(resposta);
    }
}