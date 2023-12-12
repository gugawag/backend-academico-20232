package com.example.demo.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//2023.1.37.0001
public record DadosAlunoInserirDTO(@NotEmpty String nome, @NotBlank @Pattern(regexp = "\\d{4}\\.\\d{1}\\.\\d{2}\\.\\d{4}",
        message = "Matrícula Inválida! Deve ter 11 dígitos, seperados por . .")String matricula, Integer idade) {
}
