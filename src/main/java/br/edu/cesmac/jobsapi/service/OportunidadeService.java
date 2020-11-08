package br.edu.cesmac.jobsapi.service;

import br.edu.cesmac.jobsapi.domain.Habilidade;
import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.repository.HabilidadeRepository;
import br.edu.cesmac.jobsapi.repository.OportunidadeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OportunidadeService {
    private OportunidadeRepository oportunidadeRepository;
    private HabilidadeRepository habilidadeRepository;

    public OportunidadeService(OportunidadeRepository oportunidadeRepository, HabilidadeRepository habilidadeRepository) {
        this.oportunidadeRepository = oportunidadeRepository;
        this.habilidadeRepository   = habilidadeRepository;
    }

    public Oportunidade saveOportunidade(Oportunidade oportunidade){
        if(oportunidade.getHabilidades().size() > 0) {
            List<Habilidade> habilidades =  new ArrayList<>();
            for(Habilidade habilidade: oportunidade.getHabilidades()) {
                if(habilidade.getIdHabilidade() != null) {
                    Optional<Habilidade> habilidadeCadastrada = habilidadeRepository.findById(habilidade.getIdHabilidade());
                    habilidadeCadastrada.get().getOportunidades().add(oportunidade);
                    habilidades.add(habilidadeCadastrada.get());
                }
            }
            oportunidade.setHabilidades(habilidades);
        }
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
