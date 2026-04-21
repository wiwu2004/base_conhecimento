package com.wiwu.baseconhecimento.auditoria.repository;

import com.wiwu.baseconhecimento.auditoria.entity.PerguntaAuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerguntaAuditoriaRepository
        extends JpaRepository<PerguntaAuditoriaEntity, Long> {

    List<PerguntaAuditoriaEntity> findByTipologiaCodigoOrderById(String tipologiaId);

    @Query("""
   select p from PerguntaAuditoriaEntity p
   left join fetch p.secao s
   where p.tipologia.codigo = :codigo
   order by s.ordem asc nulls last, p.id asc
""")
    List<PerguntaAuditoriaEntity> buscarPorTipologiaOrdenadoPorSecao(
            @Param("codigo") String codigo
    );

}