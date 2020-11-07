package br.edu.cesmac.jobsapi.service;

import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa savePessoa(Pessoa Pessoa){
        return pessoaRepository.save(Pessoa);
    }

    public List<Pessoa> listAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> searchById(Long idPessoa) {
        return pessoaRepository.findById(idPessoa);
    }

    public void updatePessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
    public void destroyPessoa(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    public void destroyById(Long idPessoa) {
        pessoaRepository.deleteById(idPessoa);
    }
}
