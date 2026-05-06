package com.example.ac2.ac2.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.ac2.Models.Projeto;
import com.example.ac2.ac2.Service.ProjetoService;
import com.example.ac2.dto.DadosProjetoDTO;
import com.example.ac2.dto.ProjetoDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto adicionar(@RequestBody ProjetoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public DadosProjetoDTO buscarProjetoPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/{idProjeto}/funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Long idProjeto,
            @PathVariable Long idFuncionario) {
        service.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping("/data")
    public List<Projeto> buscarPorData(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim) {

        return service.buscarPorData(inicio, fim);
    }
    @GetMapping
public List<Projeto> listarTodos() {
    return service.listarTodos();
}
}
