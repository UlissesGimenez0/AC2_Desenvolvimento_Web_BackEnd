package com.example.ac2.ac2.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.ac2.Models.Funcionario;
import com.example.ac2.ac2.Models.Projeto;
import com.example.ac2.ac2.Repository.FuncionarioRepository;
import com.example.ac2.ac2.Repository.ProjetoRepository;
import com.example.ac2.dto.DadosProjetoDTO;
import com.example.ac2.dto.ProjetoDTO;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Projeto salvar(ProjetoDTO dto) {

        Projeto p = new Projeto();
        p.setNome(dto.getNome());

        return repository.save(p);
    }

    @Override
    public DadosProjetoDTO buscarPorId(Long id) {

        Projeto p = repository.findProjetoFetchFuncionarios(id);

        if (p == null) {
            throw new RuntimeException("Projeto não encontrado");
        }

        return DadosProjetoDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .funcionarios(
                        p.getFuncionarios()
                                .stream()
                                .map(Funcionario::getNome)
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public void vincularFuncionario(Long idProjeto, Long idFuncionario) {

        Projeto projeto = repository.findById(idProjeto)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionario.getProjetos().add(projeto);

        funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Projeto> buscarPorData(LocalDate inicio, LocalDate fim) {
        return repository.findByDataInicioBetween(inicio, fim);
    }

    @Override
    public List<Projeto> listarTodos() {
        return repository.findAll();
    }
}
