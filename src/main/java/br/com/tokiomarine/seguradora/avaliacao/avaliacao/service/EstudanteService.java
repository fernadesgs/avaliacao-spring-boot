package br.com.tokiomarine.seguradora.avaliacao.avaliacao.service;

import br.com.tokiomarine.seguradora.avaliacao.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.avaliacao.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    EstudanteRepository repository;

    public void cadastrarEstudante(Estudante estudante) {
        repository.save(estudante);
    }

    public List<Estudante> buscarEstudantes() {
        return repository.findAll();
    }

    public Optional<Estudante> buscarEstudante(Long id) {
        return repository.findById(id);
    }

    public void atualizarEstudante(Estudante estudante) {
        repository.save(estudante);
    }

    public void removeEstudante(Estudante estudante) {
        repository.delete(estudante);
    }
}