package com.example.ac2.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DadosProjetoDTO {

    private Long id;
    private String nome;

    private List<String> funcionarios;
}