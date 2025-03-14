package com.example.demo.modelo;

public record AlunoListagemDTO(Long id, String nome, String matricula, Integer idade) {
    
    public AlunoListagemDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getMatricula(), aluno.getIdade());
    }
    
}
