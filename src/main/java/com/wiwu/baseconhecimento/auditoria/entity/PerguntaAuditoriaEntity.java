package com.wiwu.baseconhecimento.auditoria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pergunta_auditoria")
@NoArgsConstructor
public class PerguntaAuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String pergunta;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String significado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipologia_id")
    private TipologiaEntity tipologia;

    @ManyToOne
    @JoinColumn(name = "secao_id")
    private SecaoPerguntasEntity secao;

    public SecaoPerguntasEntity getSecao() {
        return secao;
    }

    public void setSecao(SecaoPerguntasEntity secao) {
        this.secao = secao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public TipologiaEntity getTipologia() {
        return tipologia;
    }

    public void setTipologia(TipologiaEntity tipologia) {
        this.tipologia = tipologia;
    }
}