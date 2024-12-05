package com.distribuidora.repositories;

import com.distribuidora.domains.Roupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoupaRepository extends JpaRepository<Roupa,Long> {
    Optional<Roupa> findByDescricao(String descricao);
}
