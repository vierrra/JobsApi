package br.edu.cesmac.jobsapi.service;

import br.edu.cesmac.jobsapi.domain.Empresa;
import br.edu.cesmac.jobsapi.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {

        this.empresaRepository = empresaRepository;
    }

    public Empresa salveEmpresa(Empresa empresa) {

        return empresaRepository.save(empresa);
    }

    public List<Empresa> listAll() {

        return empresaRepository.findAll();
    }

    public Optional<Empresa> searchById(Long idEmpresa) {

        return empresaRepository.findById(idEmpresa);
    }

    public void updateEmpresa(Empresa empresa) {

        empresaRepository.save(empresa);
    }

    public void destroyEmpresa(Empresa empresa) {

        empresaRepository.delete(empresa);
    }

    public  void destroyById(Long idEmpresa) {

        empresaRepository.deleteById(idEmpresa);
    }
}
