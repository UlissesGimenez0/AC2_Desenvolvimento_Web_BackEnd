package com.example.ac2.ac2.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ac2.ac2.Models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("select p from Projeto p left join fetch p.funcionarios where p.id = :id")
    Projeto findProjetoFetchFuncionarios(Long id);

    List<Projeto> findByDataInicioBetween(LocalDate inicio, LocalDate fim);
}
