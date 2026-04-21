package com.wiwu.baseconhecimento.modeloservico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo_servico_titulo")
public class ModeloServicoTituloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String significado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secao_id")
    private ModeloServicoSecaoEntity secao;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public ModeloServicoSecaoEntity getSecao() {
        return secao;
    }

    public void setSecao(ModeloServicoSecaoEntity secao) {
        this.secao = secao;
    }
}