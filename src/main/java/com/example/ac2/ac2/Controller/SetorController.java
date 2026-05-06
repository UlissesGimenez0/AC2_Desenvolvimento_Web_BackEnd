package com.example.ac2.ac2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.ac2.Models.Setor;
import com.example.ac2.ac2.Service.SetorService;
import com.example.ac2.dto.SetorDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService service;

    @PostMapping
    public void salvar(@RequestBody SetorDTO dto) {
        service.salvar(dto);
    }

    @GetMapping("/{id}")
    public Setor buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}