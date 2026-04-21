package com.wiwu.baseconhecimento.auditoria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "secao_perguntas")
public class SecaoPerguntasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer ordem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipologia_id")
    private TipologiaEntity tipologia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public TipologiaEntity getTipologia() {
        return tipologia;
    }

    public void setTipologia(TipologiaEntity tipologia) {
        this.tipologia = tipologia;
    }
}
