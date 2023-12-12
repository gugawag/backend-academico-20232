package com.example.demo.servico;

import com.example.demo.modelo.Aluno;
import com.example.demo.modelo.AlunoListagemDTO;
import com.example.demo.repositorio.AlunoRepositorioIF;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServico {

    @Autowired
    private AlunoRepositorioIF alunoRepositorio;

    public List<AlunoListagemDTO> listar() {
        return this.alunoRepositorio.findAll().stream().map(AlunoListagemDTO::new).toList();
    }

    public Aluno getAlunoPorId(Long id) {
        return this.alunoRepositorio.findById(id).orElse(null);
    }

    @Transactional
    public Aluno inserirOuAtualizar(Aluno aluno) {
        var alunoInserido = this.alunoRepositorio.save(aluno);

        if (aluno.getIdade() < 18) {
            throw new IdadeInvalidaException("Não permitido menor de idade!");
        }
        if (aluno.getNome().equals("teste")) {
            throw new RuntimeException();
        }

        aluno.setNome(aluno.getNome() + " - alterado");
        return alunoInserido;
    }

    public void apagar(Long id) {
        this.alunoRepositorio.deleteById(id);
    }

    public AlunoListagemDTO getAlunoPorMatricula(String matricula) {
        var alunoPesquisado = this.alunoRepositorio.findByMatricula(matricula);
        if (alunoPesquisado != null) {
            return new AlunoListagemDTO(alunoPesquisado);
        }
        return null;
    }
}
