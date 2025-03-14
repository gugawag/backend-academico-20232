package com.example.demo.servico;

import com.example.demo.modelo.Aluno;
import com.example.demo.modelo.AlunoListagemDTO;
import com.example.demo.repositorio.AlunoRepositorioIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepositorioIF repositorio;
    
    public List<AlunoListagemDTO> listar() {
        return this.repositorio.findAll().stream().map(AlunoListagemDTO::new).toList();
    }
    
    public Aluno inserir(Aluno aluno) {
        return this.repositorio.save(aluno);
    }
    
    public Aluno atualizar(Aluno aluno) {
        return this.repositorio.save(aluno);
    }
    
    public void remover(Long id) {
        this.repositorio.deleteById(id);
    }
    
    public Aluno getPorId(Long id) {
        return this.repositorio.findById(id).orElse(null);
    }
    
}
