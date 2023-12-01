package com.example.demo.servico;

import com.example.demo.modelo.Aluno;
import com.example.demo.repositorio.AlunoRepositorioIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServico {

    @Autowired
    private AlunoRepositorioIF alunoRepositorio;

    public List<Aluno> listar() {
        return this.alunoRepositorio.findAll();
    }

    public Aluno getAlunoPorId(Long id) {
        return this.alunoRepositorio.findById(id).orElse(null);
    }

    public Aluno inserirOuAtualizar(Aluno aluno) {
        return this.alunoRepositorio.save(aluno);
    }

    public void apagar(Long id) {
        this.alunoRepositorio.deleteById(id);
    }
}
