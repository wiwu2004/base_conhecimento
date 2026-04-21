package com.wiwu.baseconhecimento.auditoria.dto;

public class PerguntaAuditoriaDTO {

    private final String pergunta;
    private final String significado;

    public PerguntaAuditoriaDTO(String pergunta, String significado) {
        this.pergunta = pergunta;
        this.significado = significado;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getSignificado() {
        return significado;
    }
}