package com.example.ac2.ac2.Service;

import com.example.ac2.ac2.Models.Setor;
import com.example.ac2.dto.SetorDTO;

public interface SetorService {

    void salvar(SetorDTO dto);

    Setor buscarPorId(Long id);
}