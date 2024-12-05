package com.distribuidora.repositories;

import com.distribuidora.domains.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {
    Optional<Estabelecimento> findByNome(String nome);
}
