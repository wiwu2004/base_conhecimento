package com.wiwu.baseconhecimento.modeloservico.controller;

import com.wiwu.baseconhecimento.modeloservico.entity.ModeloServicoSecaoEntity;
import com.wiwu.baseconhecimento.modeloservico.repository.ModeloServicoSecaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelo-servico/secoes")
public class ModeloServicoSecaoController {

    private final ModeloServicoSecaoRepository repository;

    public ModeloServicoSecaoController(ModeloServicoSecaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ModeloServicoSecaoEntity criar(@RequestBody ModeloServicoSecaoEntity secao) {
        return repository.save(secao);
    }

    @GetMapping
    public List<ModeloServicoSecaoEntity> listar() {
        return repository.findAll();
    }
}