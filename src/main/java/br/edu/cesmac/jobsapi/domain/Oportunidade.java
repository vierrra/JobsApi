package br.edu.cesmac.jobsapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Oportunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOportunidade;
    @NotEmpty(message = "Obrigatório informar titulo!")
    @Size(max = 150)
    private String titulo;
    @NotEmpty(message = "Obrigatório informar titulo!")
    private String descricao;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataTermino;

    @ManyToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("oportunidades")
    @JoinTable(name               = "oportunidade_habilidade",
               joinColumns        = @JoinColumn(name = "idOportunidade"),
               inverseJoinColumns = @JoinColumn(name = "idHabilidade"))
    private List<Habilidade> habilidades;

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Long getIdOportunidade() {
        return idOportunidade;
    }

    public void setIdOportunidade(Long idOportunidade) {
        this.idOportunidade = idOportunidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}
