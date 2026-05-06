package com.example.ac2.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjetoDTO {
    private Long id;
    private LocalDate dataInicio;
    private String nome;
}