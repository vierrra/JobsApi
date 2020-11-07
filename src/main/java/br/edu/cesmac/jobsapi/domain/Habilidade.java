package br.edu.cesmac.jobsapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidade;
    @NotEmpty(message = "Obrigatório informar habilidade!")
    @Size(max = 100)
    private String nomeHabilidade;
    @NotEmpty(message = "Obrigatório informar descrção das habilidades")
    private String descricaoHabilidade;

    @ManyToMany(mappedBy = "habilidades", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("habilidades")
    private List<Oportunidade> oportunidades;

    @ManyToMany(mappedBy = "habilidades", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("habilidades")
    private List<Pessoa>pessoas;

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Long getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(Long idHabilidade) {
        this.idHabilidade = idHabilidade;
    }

    public String getNomeHabilidade() {
        return nomeHabilidade;
    }

    public void setNomeHabilidade(String nomeHabilidade) {
        this.nomeHabilidade = nomeHabilidade;
    }

    public String getDescricaoHabilidade() {
        return descricaoHabilidade;
    }

    public void setDescricaoHabilidade(String descricaoHabilidade) {
        this.descricaoHabilidade = descricaoHabilidade;
    }
}
