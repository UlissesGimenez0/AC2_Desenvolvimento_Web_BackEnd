package com.example.ac2.ac2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ac2.ac2.Models.Funcionario;
import com.example.ac2.ac2.Models.Projeto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("select f.projetos from Funcionario f where f.id = :id")
    List<Projeto> buscarProjetos(Long id);
}
