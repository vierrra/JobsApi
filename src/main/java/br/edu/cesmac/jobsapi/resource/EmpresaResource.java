package br.edu.cesmac.jobsapi.resource;

import br.edu.cesmac.jobsapi.domain.Empresa;
import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaResource {
    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Void> saveEmpresa(@Validated @RequestBody Empresa empresa) {
        Empresa saveEmpresa = empresaService.salveEmpresa(empresa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveEmpresa.getIdEmpresa()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    private List<Empresa> listAll() {
        return empresaService.listAll();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> searchById(@PathVariable("id") Long idEmpresa) {
        return empresaService.searchById(idEmpresa).map(empresa -> ResponseEntity.ok(empresa)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public void updateEmpresa(@Validated @RequestBody Empresa empresa) {
        empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping
    public void destroyEmpresa(@RequestBody Empresa empresa) {
        empresaService.destroyEmpresa(empresa);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idEmpresa) {
        empresaService.destroyById(idEmpresa);
    }
}
