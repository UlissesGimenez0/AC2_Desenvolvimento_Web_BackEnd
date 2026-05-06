package com.example.ac2.ac2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.ac2.Models.Projeto;
import com.example.ac2.ac2.Service.FuncionarioService;
import com.example.ac2.dto.FuncionarioDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public void salvar(@RequestBody FuncionarioDTO dto) {
        service.salvar(dto);
    }

    @GetMapping("/{id}/projetos")
    public List<Projeto> buscarProjetos(@PathVariable Long id) {
        return service.buscarProjetos(id);
    }
}