package com.example.demo.repositorio;

import com.example.demo.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositorioIF
        extends JpaRepository<Aluno, Long> {

    public Aluno findByIdadeAndMatricula(Integer idade, String matricula);
}
