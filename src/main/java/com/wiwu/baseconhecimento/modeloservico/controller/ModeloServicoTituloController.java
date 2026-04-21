package com.wiwu.baseconhecimento.modeloservico.controller;

import com.wiwu.baseconhecimento.modeloservico.entity.ModeloServicoSecaoEntity;
import com.wiwu.baseconhecimento.modeloservico.entity.ModeloServicoTituloEntity;
import com.wiwu.baseconhecimento.modeloservico.repository.ModeloServicoSecaoRepository;
import com.wiwu.baseconhecimento.modeloservico.repository.ModeloServicoTituloRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modelo-servico/titulos")
public class ModeloServicoTituloController {

    private final ModeloServicoTituloRepository tituloRepository;
    private final ModeloServicoSecaoRepository secaoRepository;

    public ModeloServicoTituloController(
            ModeloServicoTituloRepository tituloRepository,
            ModeloServicoSecaoRepository secaoRepository
    ) {
        this.tituloRepository = tituloRepository;
        this.secaoRepository = secaoRepository;
    }

    @PostMapping
    public ModeloServicoTituloEntity criar(
            @RequestParam Long secaoId,
            @RequestBody ModeloServicoTituloEntity titulo
    ) {
        ModeloServicoSecaoEntity secao =
                secaoRepository.findById(secaoId).orElseThrow();

        titulo.setSecao(secao);
        return tituloRepository.save(titulo);
    }
}