package com.example.demo.controlador;

import com.example.demo.modelo.Aluno;
import com.example.demo.modelo.AlunoListagemDTO;
import com.example.demo.modelo.DadosAlunoInserirDTO;
import com.example.demo.servico.AlunoServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoControlador {

    @Autowired
    private AlunoServico alunoServico;

    @GetMapping
    public List<AlunoListagemDTO> listar(@RequestParam(value = "matricula", required = false) String matricula) {
        if (matricula != null && !matricula.isBlank()) {
            var alunoPesquisado = this.alunoServico.getAlunoPorMatricula(matricula);
            if (alunoPesquisado != null) {
                return Collections.singletonList(alunoPesquisado);
            }
            return null;
        }
        return this.alunoServico.listar();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoPorId(@PathVariable("id") Long idAluno) {
        return this.alunoServico.getAlunoPorId(idAluno);
    }

    @PostMapping
    public Aluno inserir(@RequestBody @Valid DadosAlunoInserirDTO aluno) {
        var alunoAInserir = new Aluno(aluno.nome(), aluno.idade(), aluno.matricula());
        return this.alunoServico.inserirOuAtualizar(alunoAInserir);
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
