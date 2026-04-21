package com.wiwu.baseconhecimento.auditoria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tipologia")
@NoArgsConstructor
public class TipologiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String codigo; // Ex: GA, GU

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @OneToMany(
            mappedBy = "tipologia",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<PerguntaAuditoriaEntity> perguntas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PerguntaAuditoriaEntity> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<PerguntaAuditoriaEntity> perguntas) {
        this.perguntas = perguntas;
    }
}
