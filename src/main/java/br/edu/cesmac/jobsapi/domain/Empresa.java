package br.edu.cesmac.jobsapi.domain;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    @NotEmpty(message = "Obrigatório informar o nome da empresa!")
    @Size(max = 150)
    private String nomeEmpresa;
    @NotEmpty(message = "Obrigatório informar o email!")
    @Size(max = 150)
    @Email(message = "Formato do email inválido")
    @UniqueElements
    private String email;
    @NotEmpty(message = "Obrigatório informar o site!")
    @Size(max = 150)
    private String site;
    @OneToMany(mappedBy = "empresa")
    private List<Oportunidade> oportunidades;

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }
}
