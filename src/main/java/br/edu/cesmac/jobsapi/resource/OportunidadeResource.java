package br.edu.cesmac.jobsapi.resource;

import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.service.OportunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/oportunidade")
public class OportunidadeResource {
    @Autowired
    OportunidadeService oportunidadeService;

    @PostMapping
    public ResponseEntity<Void> saveOportunidade(@Validated @RequestBody Oportunidade oportunidade) {
        Oportunidade saveOportunidade = oportunidadeService.saveOportunidade(oportunidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveOportunidade.getIdOportunidade()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public void updateOportunidade(@Validated @RequestBody Oportunidade oportunidade) {
        oportunidadeService.updateOportunidade(oportunidade);
    }

    @DeleteMapping
    public void destroyOportunidade(@RequestBody Oportunidade oportunidade) {
        oportunidadeService.destroyOportunidade(oportunidade);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idOportunidade) {
        oportunidadeService.destroyById(idOportunidade);
    }
}
