package br.edu.cesmac.jobsapi.service;

import br.edu.cesmac.jobsapi.domain.Habilidade;
import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.repository.HabilidadeRepository;
import br.edu.cesmac.jobsapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;
    private HabilidadeRepository habilidadeRepository;

    public PessoaService(PessoaRepository pessoaRepository, HabilidadeRepository habilidadeRepository) {

        this.pessoaRepository     = pessoaRepository;
        this.habilidadeRepository = habilidadeRepository;
    }

    public Pessoa savePessoa(Pessoa pessoa){
        if(pessoa.getHabilidades().size() > 0) {
            List<Habilidade> habilidades =  new ArrayList<>();
            for(Habilidade habilidade: pessoa.getHabilidades()) {
                if(habilidade.getIdHabilidade() != null) {
                    Optional<Habilidade> habilidadeCadastrada = habilidadeRepository.findById(habilidade.getIdHabilidade());
                    habilidadeCadastrada.get().getPessoas().add(pessoa);
                    habilidades.add(habilidadeCadastrada.get());
                } else {
                    List<Pessoa> pessoas = new ArrayList<>();
                    pessoas.add(pessoa);
                    habilidade.setPessoas(pessoas);
                    habilidades.add(habilidade);
                }
            }
            //pessoa.setHabilidades(habilidades);
        }

        return pessoaRepository.save(pessoa);
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
