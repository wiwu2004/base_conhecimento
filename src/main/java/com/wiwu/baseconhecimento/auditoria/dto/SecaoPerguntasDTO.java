package com.wiwu.baseconhecimento.auditoria.dto;

import java.util.List;

public class SecaoPerguntasDTO {

    private final String titulo;
    private final List<PerguntaAuditoriaDTO> perguntas;

    public SecaoPerguntasDTO(String titulo, List<PerguntaAuditoriaDTO> perguntas) {
        this.titulo = titulo;
        this.perguntas = perguntas;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<PerguntaAuditoriaDTO> getPerguntas() {
        return perguntas;
    }
}
