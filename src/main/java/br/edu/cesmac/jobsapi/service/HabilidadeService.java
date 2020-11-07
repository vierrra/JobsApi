package br.edu.cesmac.jobsapi.service;

import br.edu.cesmac.jobsapi.domain.Habilidade;
import br.edu.cesmac.jobsapi.repository.HabilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadeService {
    private HabilidadeRepository habilidadeRepository;

    public HabilidadeService(HabilidadeRepository habilidadeRepository) {
        this.habilidadeRepository = habilidadeRepository;
    }

    public Habilidade saveHabilidade(Habilidade habilidade){
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
