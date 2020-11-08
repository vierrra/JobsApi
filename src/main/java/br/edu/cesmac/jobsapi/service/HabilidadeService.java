package br.edu.cesmac.jobsapi.service;

import br.edu.cesmac.jobsapi.domain.Habilidade;
import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.repository.HabilidadeRepository;
import br.edu.cesmac.jobsapi.repository.OportunidadeRepository;
import br.edu.cesmac.jobsapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HabilidadeService {
    private HabilidadeRepository habilidadeRepository;
    private PessoaRepository pessoaRepository;
    private OportunidadeRepository oportunidadeRepository;

    public HabilidadeService(HabilidadeRepository habilidadeRepository, PessoaRepository pessoaRepository, OportunidadeRepository oportunidadeRepository) {
        this.habilidadeRepository   = habilidadeRepository;
        this.pessoaRepository       = pessoaRepository;
        this.oportunidadeRepository = oportunidadeRepository;
    }

    public Habilidade saveHabilidade(Habilidade habilidade){
        if(habilidade.getPessoas().size() > 0) {
            List<Pessoa> pessoas = new ArrayList<>();
            for(Pessoa pessoaHabilidade: habilidade.getPessoas()) {
                if(pessoaHabilidade.getIdPessoa() != null) {
                    Optional<Pessoa> pessoaExistente = pessoaRepository.findById(pessoaHabilidade.getIdPessoa());
                    pessoaExistente.get().getHabilidades().add(habilidade);
                    pessoas.add(pessoaExistente.get());
                }
                else {
                    List<Habilidade> habilidades = new ArrayList<>();
                    habilidades.add(habilidade);
                    pessoaHabilidade.setHabilidades(habilidades);
                    pessoas.add(pessoaHabilidade);
                }
            }
            habilidade.setPessoas(pessoas);
        }

        if(habilidade.getOportunidades().size() > 0) {
            List<Oportunidade> oportunidades = new ArrayList<>();
            for(Oportunidade oportunidadeHabilidade: habilidade.getOportunidades()) {
                if(oportunidadeHabilidade.getHabilidades() != null) {
                    Optional<Oportunidade> oportunidadeExistente = oportunidadeRepository.findById(oportunidadeHabilidade.getIdOportunidade());
                    oportunidadeExistente.get().getHabilidades().add(habilidade);
                    oportunidades.add(oportunidadeExistente.get());
                }
                else {
                    List<Habilidade> habilidades = new ArrayList<>();
                    habilidades.add(habilidade);
                    oportunidadeHabilidade.setHabilidades(habilidades);
                    oportunidades.add(oportunidadeHabilidade);
                }
            }
            habilidade.setOportunidades(oportunidades);
        }
        return habilidadeRepository.save(habilidade);
    }

    public List<Habilidade> listAll() {
        return habilidadeRepository.findAll();
    }

    public Optional<Habilidade> searchById(Long idHabilidade) {
        return habilidadeRepository.findById(idHabilidade);
    }

    public void updateHabilidade(Habilidade habilidade) {

        habilidadeRepository.save(habilidade);
    }
    public void destroyHabilidade(Habilidade habilidade) {
        habilidadeRepository.delete(habilidade);
    }

    public void destroyById(Long idHabilidade) {
        habilidadeRepository.deleteById(idHabilidade);
    }
}
