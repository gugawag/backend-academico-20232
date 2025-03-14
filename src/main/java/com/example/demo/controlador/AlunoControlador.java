package com.example.demo.controlador;

import com.example.demo.modelo.Aluno;
import com.example.demo.modelo.AlunoListagemDTO;
import com.example.demo.servico.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoControlador {
    
    @Autowired
    private AlunoService servico;
    
    @GetMapping
    public List<AlunoListagemDTO> listar() {
        return this.servico.listar();
    }
    
    @PostMapping
    public Aluno inserir(@RequestBody Aluno aluno) {
        return this.servico.inserir(aluno);
    }
    
    @DeleteMapping("/{id}")
    public void remover(@PathVariable("id") Long id) {
        this.servico.remover(id);
    }
    
   @PutMapping("/{id}")
   public Aluno atualizar(@RequestBody Aluno aluno) {
        return this.servico.atualizar(aluno);
   }
   
   @GetMapping("/{id}")
   public Aluno getPorId(@PathVariable Long id) {
        return this.servico.getPorId(id);
   }
   
   
}
