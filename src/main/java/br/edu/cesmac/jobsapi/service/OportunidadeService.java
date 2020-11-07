package br.edu.cesmac.jobsapi.service;

import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.repository.OportunidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadeService {
    private OportunidadeRepository oportunidadeRepository;

    public OportunidadeService(OportunidadeRepository oportunidadeRepository) {
        this.oportunidadeRepository = oportunidadeRepository;
    }

    public Oportunidade saveOportunidade(Oportunidade oportunidade){
        return oportunidadeRepository.save(oportunidade);
    }

    public List<Oportunidade> listAll() {
        return oportunidadeRepository.findAll();
    }

    public Optional<Oportunidade> searchById(Long idOportunidade) {
        return oportunidadeRepository.findById(idOportunidade);
    }

    public void updateOportunidade(Oportunidade oportunidade) {
        oportunidadeRepository.save(oportunidade);
    }
    public void destroyOportunidade(Oportunidade oportunidade) {
        oportunidadeRepository.delete(oportunidade);
    }

    public void destroyById(Long idOportunidade) {
        oportunidadeRepository.deleteById(idOportunidade);
    }
}
