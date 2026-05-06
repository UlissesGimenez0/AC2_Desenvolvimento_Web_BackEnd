package com.example.ac2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private Long setorId;
}