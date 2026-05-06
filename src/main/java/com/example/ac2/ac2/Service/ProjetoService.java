package com.example.ac2.ac2.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.ac2.ac2.Models.Projeto;
import com.example.ac2.dto.DadosProjetoDTO;
import com.example.ac2.dto.ProjetoDTO;

public interface ProjetoService {

    Projeto salvar(ProjetoDTO dto);

    DadosProjetoDTO buscarPorId(Long id);

    List<Projeto> buscarPorData(LocalDate inicio, LocalDate fim);

    void vincularFuncionario(Long idProjeto, Long idFuncionario);
    List<Projeto> listarTodos();
}