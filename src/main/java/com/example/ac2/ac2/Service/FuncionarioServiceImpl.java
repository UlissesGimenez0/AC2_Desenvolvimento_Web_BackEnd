package com.example.ac2.ac2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.ac2.Models.Funcionario;
import com.example.ac2.ac2.Models.Projeto;
import com.example.ac2.ac2.Repository.FuncionarioRepository;
import com.example.ac2.dto.FuncionarioDTO;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void salvar(FuncionarioDTO dto) {

        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());

        repository.save(f);
    }

    @Override
    public List<Projeto> buscarProjetos(Long idFuncionario) {
        return repository.buscarProjetos(idFuncionario);
    }
}