package com.sammy.repositorio;

import com.sammy.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Estende JpaRepository para ganhar funcionalidades CRUD para a entidade 'Nota'
@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
}
