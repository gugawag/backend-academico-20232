package com.example.demo.controlador;

import com.example.demo.modelo.Aluno;
import com.example.demo.servico.AlunoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoControlador {

    @Autowired
    private AlunoServico alunoServico;

    @GetMapping
    public List<Aluno> listar() {
        return this.alunoServico.listar();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoPorId(@PathVariable("id") Long idAluno) {
        return this.alunoServico.getAlunoPorId(idAluno);
    }

    @PostMapping
    public Aluno inserir(@RequestBody Aluno aluno) {
        return this.alunoServico.inserirOuAtualizar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@RequestBody Aluno aluno) {
        return this.alunoServico.inserirOuAtualizar(aluno);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        this.alunoServico.apagar(id);
    }

}
