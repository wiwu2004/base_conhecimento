package com.wiwu.baseconhecimento.modeloservico.repository;

import com.wiwu.baseconhecimento.modeloservico.entity.ModeloServicoTituloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloServicoTituloRepository
        extends JpaRepository<ModeloServicoTituloEntity, Long> {

    List<ModeloServicoTituloEntity> findBySecaoIdOrderById(Long secaoId);
}