package com.wiwu.baseconhecimento.auditoria.repository;

import com.wiwu.baseconhecimento.auditoria.dto.TipologiaResumoDTO;
import com.wiwu.baseconhecimento.auditoria.entity.TipologiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TipologiaRepository
        extends JpaRepository<TipologiaEntity, Long> {

    Optional<TipologiaEntity> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);


    @Query("""
        select new com.wiwu.baseconhecimento.auditoria.dto.TipologiaResumoDTO(
            t.codigo,
            t.nome,
            count(p.id)
        )
        from TipologiaEntity t
        left join PerguntaAuditoriaEntity p on p.tipologia = t
        group by t.codigo, t.nome
        order by t.codigo
    """)
    List<TipologiaResumoDTO> listarResumo();

}