package br.edu.cesmac.jobsapi.resource;

import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Void> savePessoa(@Validated @RequestBody Pessoa pessoa) {
        Pessoa savePessoa = pessoaService.savePessoa(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savePessoa.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public void updatePessoa(@Validated @RequestBody Pessoa pessoa) {
        pessoaService.updatePessoa(pessoa);
    }

    @DeleteMapping
    public void destroyOportunidade(@RequestBody Pessoa pessoa) {
        pessoaService.destroyPessoa(pessoa);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idPessoa) {
        pessoaService.destroyById(idPessoa);
    }
}
