package com.example.ac2.ac2.Service;

import java.util.List;

import com.example.ac2.ac2.Models.Projeto;
import com.example.ac2.dto.FuncionarioDTO;

public interface FuncionarioService {

    void salvar(FuncionarioDTO dto);

  
    List<Projeto> buscarProjetos(Long idFuncionario);
}