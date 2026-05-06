package com.example.ac2.ac2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.ac2.Models.Setor;
import com.example.ac2.ac2.Repository.SetorRepository;
import com.example.ac2.dto.SetorDTO;

@Service
public class SetorServiceImpl implements SetorService {

    @Autowired
    private SetorRepository repository;

    @Override
    public void salvar(SetorDTO dto) {

        Setor s = new Setor();
        s.setNome(dto.getNome());

        repository.save(s);
    }

    @Override
    public Setor buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }
}