package com.wiwu.baseconhecimento.modeloservico.controller;

import com.wiwu.baseconhecimento.modeloservico.entity.ModeloServicoSecaoEntity;
import com.wiwu.baseconhecimento.modeloservico.entity.ModeloServicoTituloEntity;
import com.wiwu.baseconhecimento.modeloservico.repository.ModeloServicoSecaoRepository;
import com.wiwu.baseconhecimento.modeloservico.repository.ModeloServicoTituloRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/modelo-servico")
public class ModeloServicoController {

    private final ModeloServicoSecaoRepository secaoRepository;
    private final ModeloServicoTituloRepository tituloRepository;

    public ModeloServicoController(
            ModeloServicoSecaoRepository secaoRepository,
            ModeloServicoTituloRepository tituloRepository
    ) {
        this.secaoRepository = secaoRepository;
        this.tituloRepository = tituloRepository;
    }

    @GetMapping
    public List<SecaoResponse> listarModeloServico() {

        List<ModeloServicoSecaoEntity> secoes =
                secaoRepository.findAll()
                        .stream()
                        .sorted((a, b) -> a.getOrdem().compareTo(b.getOrdem()))
                        .toList();

        List<SecaoResponse> response = new ArrayList<>();

        for (ModeloServicoSecaoEntity secao : secoes) {

            List<ModeloServicoTituloEntity> titulos =
                    tituloRepository.findBySecaoIdOrderById(secao.getId());

            List<TituloResponse> titulosResponse = titulos.stream()
                    .map(t -> new TituloResponse(
                            t.getTitulo(),
                            t.getSignificado()
                    ))
                    .toList();

            response.add(new SecaoResponse(
                    secao.getNome(),
                    titulosResponse
            ));
        }

        return response;
    }


    public record SecaoResponse(
            String secao,
            List<TituloResponse> titulos
    ) {}

    public record TituloResponse(
            String titulo,
            String significado
    ) {}
}