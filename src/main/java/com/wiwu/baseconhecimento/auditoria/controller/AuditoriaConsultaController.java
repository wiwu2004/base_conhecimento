package com.wiwu.baseconhecimento.auditoria.controller;

import com.wiwu.baseconhecimento.auditoria.dto.PerguntaAuditoriaDTO;
import com.wiwu.baseconhecimento.auditoria.dto.TipologiaResumoDTO;
import com.wiwu.baseconhecimento.auditoria.entity.PerguntaAuditoriaEntity;
import com.wiwu.baseconhecimento.auditoria.repository.PerguntaAuditoriaRepository;
import com.wiwu.baseconhecimento.auditoria.repository.TipologiaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaConsultaController {

    private final PerguntaAuditoriaRepository perguntaAuditoriaRepository;
    private final TipologiaRepository tipologiaRepository;

    public AuditoriaConsultaController(PerguntaAuditoriaRepository perguntaRepository, TipologiaRepository tipologiaRepository) {
        this.perguntaAuditoriaRepository = perguntaRepository;
        this.tipologiaRepository = tipologiaRepository;
    }


    @GetMapping("/tipologias")
    public List<TipologiaResumoDTO> listarTipologias(){
        return  tipologiaRepository.listarResumo();
    }

    @GetMapping("/{codigoTipologia}/perguntas")
    public ResponseEntity<List<PerguntaAuditoriaDTO>> listarPerguntasPorTipologia(
            @PathVariable String codigoTipologia
    ) {
        List<PerguntaAuditoriaDTO> perguntas = perguntaAuditoriaRepository
                .findByTipologiaCodigoOrderById(codigoTipologia)
                .stream()
                .map(p -> new PerguntaAuditoriaDTO(
                        p.getPergunta(),
                        p.getSignificado()
                ))
                .toList();
        return ResponseEntity.ok(perguntas);

    }




}
