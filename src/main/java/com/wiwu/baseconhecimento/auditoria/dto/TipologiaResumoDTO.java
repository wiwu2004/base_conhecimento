package com.wiwu.baseconhecimento.auditoria.dto;

public class TipologiaResumoDTO {

    private final String codigo;
    private final String nome;
    private final Long totalPerguntas;

    public TipologiaResumoDTO(String codigo, String nome, Long totalPerguntas){
        this.codigo = codigo;
        this.nome = nome;
        this.totalPerguntas = totalPerguntas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Long getTotalPerguntas() {
        return totalPerguntas;
    }
}
