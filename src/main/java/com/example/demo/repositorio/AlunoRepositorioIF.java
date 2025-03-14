package com.example.demo.repositorio;

import com.example.demo.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepositorioIF
        extends JpaRepository<Aluno, Long> {
    
    public Aluno findByIdadeAndMatricula(Integer idade, String matricula);
    
    public Aluno findByNome(String nome);
    
    @Query("FROM Aluno a where a.idade>=18")
    public List<Aluno> getAlunosMaioresIdade();
    
}
