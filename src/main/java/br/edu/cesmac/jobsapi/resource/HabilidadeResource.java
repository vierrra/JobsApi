package br.edu.cesmac.jobsapi.resource;

import br.edu.cesmac.jobsapi.domain.Habilidade;
import br.edu.cesmac.jobsapi.domain.Oportunidade;
import br.edu.cesmac.jobsapi.domain.Pessoa;
import br.edu.cesmac.jobsapi.service.HabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeResource {
    @Autowired
    HabilidadeService habilidadeService;

    @PostMapping
    public ResponseEntity<Void> saveHabilidade(@Validated @RequestBody Habilidade habilidade) {
        Habilidade saveHabilidade = habilidadeService.saveHabilidade(habilidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveHabilidade.getIdHabilidade()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    private List<Habilidade> listAll() {
        return habilidadeService.listAll();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Habilidade> searchById(@PathVariable("id") Long idHabilidade) {
        return habilidadeService.searchById(idHabilidade).map(habilidade -> ResponseEntity.ok(habilidade)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public void updateHabilidade(@Validated @RequestBody Habilidade habilidade) {
        habilidadeService.updateHabilidade(habilidade);
    }

    @DeleteMapping
    public void destroyHabilidade(@RequestBody Habilidade habilidade) {
        habilidadeService.destroyHabilidade(habilidade);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idHabilidade) {
        habilidadeService.destroyById(idHabilidade);
    }
}
